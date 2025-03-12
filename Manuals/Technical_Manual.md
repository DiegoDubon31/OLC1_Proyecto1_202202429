# **Technical Manual - Prisoner's Dilemma**
**Version:** 1.0  
**Author:** Diego Andrés Dubón Samayoa  
**Date:** March 2025  

## **Introduction**
This project simulates the *Prisoner's Dilemma* using strategies defined in a custom scripting language **(.cmp)**. It performs *lexical* and *syntactical* analysis, *interprets* the strategies, and executes matches while generating reports for errors and tokens.

## **Project Objective**
Develop a software solution capable of **analyzing, processing, and executing** a custom file strategy-based **Prisoner’s Dilemma simulation**, using JFlex and Cup, **lexical and syntactical analysis** tools.

## **Technical Requirements**
- Have strong knowledge of **POO**
- Knowledge in **Java** the programming language
- Previous experience working with **JFlex** and **CUP**
- Have **Java** with **Ant**

## **Software Architecture**
The system follows a **modular architecture**:
1. **User loads a .cmp file** → Lexical Analysis (JFlex)
2. **Syntax check** → CUP constructs the AST
3. **AST Interpretation:**
    - Strategies & Matches are stored in Context
    - RunStmt executes rounds step-by-step
    - Each Strategy’s rules are evaluated using IF-ELSE logic
    - Decisions are stored & updated
4. **Final results displayed**
5. **HTML reports generated** (Errors & Tokens)

## **Technologies used**
- Apache NetBeans IDE 22
- JDK (Version 21.0.4 2024-07-16 LTS)
- JFlex (Version 1.9.1)
- CUP (Version 11b)

## **Main Components**
This is the **structure** of the project: 

* 📁src/
    * 📁Analyzer/
        * 📄AnalyzerGenerator.java
        * 📄error.java
        * 📄Lexer.java
        * 📄Lexer.jflex
        * 📄Lists.java
        * 📄Parser.cup
        * 📄Parser.java
        * 📄sym.java
        * 📄Token.java
    * 📁AST/
        * 📁Functions/
            * 📄Fget_last_n_moves.java
            * 📄Fget_move.java
            * 📄Fget_moves_count.java
            * 📄Flast_move.java
        * 📁Interpreter/
            * 📄Context.java
            * 📄IAST.java
        * 📁Literal/
            * 📄Literal.java
        * 📁Main/
            * 📄MainStmt.java
            * 📄RunStmt.java
        * 📁Match/
            * 📄MatchStmt.java
        * 📁Random/
            * 📄DeterministicGenerator.java
            * 📄RandomGenerator.java
        * 📁States/
            * 📄Srandom.java
            * 📄Sround_number.java
            * 📄Stotal_rounds.java
        * 📁Strategy/
            * 📄BoolCond.java
            * 📄BoolExpr.java
            * 📄IfStmt.java
            * 📄Strategy.java
    * 📄main.java
    * 📄Front.java

### **1. 📁Analyzer**
As the name says, here occurs the analysis process, both lexical and syntactical for the specific **.cmp** files for strategies, matches and the main statement to execute matches between strategies.

- **📄AnalyzerGenerator.java** it is used to **compile** the JFlex file and CUP file into their java representation by just running this file. 
- **📄error.java** this used for the report of lexical errors so is used in Lists.
- **📄Lexer.jflex** Uses **JFlex** for lexical analysis. 
- **📄Parser.cup** Uses **CUP** for syntactical analysis.
- **📄Lists.java** here are the list of tokens and errors to generate the **html** reports. In the lexical analysis both token and error list are created.
- **📄sym.java** CUP generates this so the java representation of JFlex can work properly. 
- **📄Token.java** this used for the report of tokens so is used in Lists.

In this part in the CUP file the AST is created, this is not an exact representation just an abstraction so you can visualize what is happening while is accepting the grammar:

![AST representation](https://i.ibb.co/23ggGmnr/ast.png)

So as you can see in the **Parser.cup** file the productions start with S as the image and has 3 childs. This is the minimal representation of the AST because it can have **n** strategies,**n** matches, and **n** run statements. The conditions have IfStmt and this has BoolExpr and this has BoolCond this has two sides so it goes deep down, is just a basic representation. So please follow the productions and the non terminals and you will understand how the AST is created. This is **important** because by traversing the AST is that the program is interpreted. This is explained in the other section. 


### **2. Interpreter**
Interprets AST nodes and executes strategies.
Used the design pattern Interpreter this is my interface **IAST.java**:

```java
public interface IAST {
    Object interpret(Context context);
}
```
The function is type **Object** to only use one interface, so there is a lot of casting. 

In the **Context** is the control of everything to run the matches. It has a list of the matches, strategies, it keeps the record of total rounds, round number, random, the access to strategy history, the score for each player so here are all the states of the game.

#### **Order of interpreting**
As you can see above the root of the AST has 3 childs and follows the next path: 

1. Strategies
2. Matches
3. Run Statements

So as we are not playing the match until the **run statement** in the interpret method of **Strategy** and **MatchStmt** them are saved in the list of context. 

```java
 @Override
public Void interpret(Context context) {
    context.addStrat(ID, this);
    return null;
}
```
```java
@Override
public Void interpret(Context context) {
    context.addMatch(id, this);
    return null;
}
```
For **MatchStmt** is basically only saving the data, while in **Strategy** we have the **rules** that we need to run **every round** for that reason now we will focus on **Strategy**

#### **Strategy**
```java
public class Strategy implements IAST{
    private String ID;
    private String initial;
    private ArrayList<IAST> rules; 
    private ArrayList<String> history;
    private boolean inUse;
    private RandomGenerator random;

    public Strategy(String ID, String initial, ArrayList<IAST> rules) {
        this.ID = ID;
        this.initial = initial;
        this.rules = rules;
        this.history = new ArrayList<>();
        this.inUse = false;
    }
}
```
Before we go deep in the **RunStmt** and explaining the **Round-by-Round** we need to understand how Strategies work. Each Strategy has his own history this as an ArrayList of String it can be **"C"** or **"D"** (Cooperate or Defect). This is helpful so in the context we can access to the states **self_history** or **opponent_history**. For this reason we also have a **flag** the boolean **inUse** so in context will be only 2 strategies in use and the rules are evaluated all of them until one is true so we have a **current Strategy** the one we are evaluating this is useful because in this way we can access the **self_history** or **opponent_history** correctly also for the **random** state each Strategy has its own instance so there is no issue with this state every time it is called. Now with understanding of the strategies let's go the **core** of the interpreter. 

#### **RunStmt**
The MainStmt is the one that save the list of RunStmt so here is how we interpret each one of the list: 
```java
    @Override
    public Object interpret(Context context) {
        for (RunStmt run : runs) {
           run.interpret(context);
        }
        return null;
    }
```
So let's focus in the **RunStmt**. We have the ID of the matches in a list and the **seed** for the random state. This is why above in the **MatchStmt** we saved the match in the context list so we can access them here. 

In a few words, we iterate the matches with a forEach, we collect the strategies, scoring, totalrounds and start iterate each rules of the strategies with a forEach and we break the loop if we find one condition true and save the decision in the history of the strategy, if not the else will be saved. Let's go step by step:
1. **Collecting match data:** We validate that the seed is a positive number and get the info from the match in help with the context. We collect the Match ID, the 2 strategies, total rounds and score. After getting data we set the values in the context as the total rounds and scoring. The setOut is to have a String with all the info of the Match and the show it in the console of the Front (GUI). Is not to much to explain basically is get and set data in the next step is the round by round.
```java
@Override
public Void interpret(Context context) {
    MatchStmt match; 
    String id1;
    String id2;
    int coop, defect, traitor, betrayed =0;
    if (seed>=0) {
        context.setRandom(seed);
        for (String matchId : matchIds) {
            context.setOut("=== Match "+matchId+" ===\n");
            context.setOut("Configuration: \n");
            match = context.getMatch(matchId);
            id1 = match.getS1();
            id2 = match.getS2();
            context.setOut("Strategies: "+id1+" vs "+id2+ "\n");
            context.setTotalRounds(match.getRounds());
            //context.setScore(match.getScoring());
            context.setOut("Rounds: "+context.getTotalRounds()+"\n");
            context.setOut("Scoring: \n");
            coop = match.getScoring().get("mutual cooperation");
            defect = match.getScoring().get("mutual defection");
            traitor = match.getScoring().get("betrayal reward");
            betrayed = match.getScoring().get("betrayal punishment");
            if (traitor > coop && coop > defect && defect > betrayed) {
                context.setOut("\t-Mutual Cooperation: "+coop+"\n");
                context.setOut("\t-Mutual Defection: "+defect+"\n");
                context.setOut("\t-Betrayal: "+traitor+"/"+betrayed+" (traitor/betrayed)"+"\n");
            }else{
                context.setOut("Scoring not valid, scoring should be T > R > P > S");
                System.out.println(context.getOut());
                break;
            }

            Strategy strat1 = context.getStrat(id1);
            Strategy strat2 = context.getStrat(id2);
            strat1.setRandom(seed);
            strat2.setRandom(seed);
            strat1.setInUse(true);
            strat2.setInUse(true);
            ArrayList<IAST> ifs1;
            ArrayList<IAST> ifs2;
            String result1="";
            String result2="";
```
2. **Round-by-Round:** 
- Here if is the first round we play the initial move of each Strategy and skip the rest of iteration. Also we compare the decision that each player did so we can set the score for the round.
```java
            context.setOut("The round-by-round progression:\n");
            for (int i = 1; i <= context.getTotalRounds(); i++) {
                if (i==1) {
                    strat1.addHistory(strat1.getInitial());
                    strat2.addHistory(strat2.getInitial());

                    if (strat1.getHistory().get(0).equals("C") && strat2.getHistory().get(0).equals("C")) {
                        context.setScore1(coop);
                        context.setScore2(coop);
                        context.setOut("Round "+i+": "+id1+"=COOPERATE, "+id2+"=COOPERATE");
                        context.setOut("("+coop+"/"+coop+")\n");
                    }else if (strat1.getHistory().get(0).equals("D") && strat2.getHistory().get(0).equals("D")) {
                        context.setScore1(defect);
                        context.setScore2(defect);
                        context.setOut("Round "+i+": "+id1+"=DEFECT, "+id2+"=DEFECT ");
                        context.setOut("("+defect+"/"+defect+")\n");
                    }else if (strat1.getHistory().get(0).equals("C") && strat2.getHistory().get(0).equals("D")) {
                        context.setScore1(betrayed);
                        context.setScore2(traitor);
                        context.setOut("Round "+i+": "+id1+"=COOPERATE, "+id2+"=DEFECT ");
                        context.setOut("("+betrayed+"/"+traitor+")\n");
                    }else if (strat1.getHistory().get(0).equals("D") && strat2.getHistory().get(0).equals("C")) {
                        context.setScore1(traitor);
                        context.setScore2(betrayed);
                        context.setOut("Round "+i+": "+id1+"=DEFECT, "+id2+"=COOPERATE ");
                        context.setOut("("+traitor+"/"+betrayed+")\n");
                    }
                    context.nextRound();
                    continue;

                }
```

- Now we start to iterate rule by rule until we find one true, in case no if is true the else will be played. Before starting iterate the rules we set an current Strategy so with this the access to self_history or opponent_history will be correct and finally we compare decisions to set the score of the round. 
```java
                context.setActStrat(id1);
                ifs1 = strat1.getRules();
                for (IAST If1 : ifs1) {
                    result1 = (String)If1.interpret(context);
                    if (result1 != null) {
                        strat1.addHistory(result1);
                        break;
                    }

                }


                context.setActStrat(id2);
                ifs2 = strat2.getRules();
                for (IAST If2 : ifs2) {
                    result2 = (String)If2.interpret(context);
                    if (result2 != null) {
                        strat2.addHistory(result2);
                        break;
                    }

                }

                    if (result1.equals("C") && result2.equals("C")) {
                        context.setScore1(coop);
                        context.setScore2(coop);
                        context.setOut("Round "+i+": "+id1+"=COOPERATE, "+id2+"=COOPERATE ");
                        context.setOut("("+coop+"/"+coop+")\n");
                    }else if (result1.equals("D") && result2.equals("D")) {
                        context.setScore1(defect);
                        context.setScore2(defect);
                        context.setOut("Round "+i+": "+id1+"=DEFECT, "+id2+"=DEFECT ");
                        context.setOut("("+defect+"/"+defect+")\n");
                    }else if (result1.equals("C") && result2.equals("D")) {
                        context.setScore1(betrayed);
                        context.setScore2(traitor);
                        context.setOut("Round "+i+": "+id1+"=COOPERATE, "+id2+"=DEFECT ");
                        context.setOut("("+betrayed+"/"+traitor+")\n");
                    }else if (result1.equals("D") && result2.equals("C")) {
                        context.setScore1(traitor);
                        context.setScore2(betrayed);
                        context.setOut("Round "+i+": "+id1+"=DEFECT, "+id2+"=COOPERATE ");
                        context.setOut("("+traitor+"/"+betrayed+")\n");
                    }
                    context.nextRound();

            }
```
- After running all the rounds we change the flag of the strategy as is not use anymore and calculate the final points, percent of cooperations and defections, and init the context again so there is no issue with the other match:
```java
            strat1.setInUse(false);
            strat2.setInUse(false);
            double Dcounter=0;
            double Ccounter=0;
            context.setOut("Match summary: \n");
            context.setOut(id1+": \n");
            context.setOut("\t-Final points: "+context.getScore1()+"\n");
            for (String s : strat1.getHistory()) {
                if (s.equals("D")) {
                    Dcounter++;
                }else{
                    Ccounter++;
                }
            }

            double percent=0;
            percent = (Ccounter/context.getTotalRounds())*100;
            context.setOut("\t-Cooperations: "+percent+"%\n");
            percent = (Dcounter/context.getTotalRounds())*100;
            context.setOut("\t-Defections: "+percent+"%\n");
            Dcounter=0;
            Ccounter=0;
            context.setOut(id2+": \n");
            context.setOut("\t-Final points: "+context.getScore2()+"\n");
            for (String s : strat2.getHistory()) {
                if (s.equals("D")) {
                    Dcounter++;
                }else{
                    Ccounter++;
                }
            }
            percent = (Ccounter/context.getTotalRounds())*100;
            context.setOut("\t-Cooperations: "+percent+"%\n");
            percent = (Dcounter/context.getTotalRounds())*100;
            context.setOut("\t-Defections: "+percent+"%\n");

            System.out.println(context.getOut());
            strat1.initHistory();
            strat2.initHistory();
            context.init();
        }

    }else{
        context.setOut("Seed not valid, seed should be greater or equal than 0");
        System.out.println(context.getOut());
        return null;
    }
    return null;
}
```
#### **Summary**
1. Get the data of the Match.
2. Iterate round-by-round the rules of each strategy and get the decision.
3. Calculate points, defections, cooperations and init again all the context. 

## **Conclusion
The Prisoner’s Dilemma Simulator is a robust software solution designed to analyze, process, and execute strategy-based matches using a custom scripting language (.cmp). The system integrates lexical and syntactical analysis with an interpreter-based execution model, ensuring accurate and structured processing of user-defined strategies.

By leveraging JFlex and CUP, the program efficiently tokenizes and parses input files, constructing an Abstract Syntax Tree (AST) that serves as the foundation for strategy interpretation and match execution. Using the Interpreter design pattern, strategies are dynamically evaluated, allowing for flexible and scalable gameplay simulations.

The project follows a modular architecture, incorporating:

- **Frontend** (GUI) for user interaction and file management.
- **Analyzer** for lexical and syntactical validation.
- **Interpreter** for executing strategy rules and generating round-by-round match results.
- **Report Generator** to provide detailed error and token tracking in HTML format.

Through this structured approach, the simulator ensures accurate game execution, enabling users to define and test various strategic behaviors under a controlled environment. The deterministic random generator ensures consistent and reproducible results, further enhancing the system’s reliability.

## **Final Thoughts**
This project successfully demonstrates the practical application of **compiler theory, lexical and syntactical analysis**, and **tree-based interpretation** within the domain of game theory and strategic **decision-making**. It provides a solid foundation for further research and expansion in strategy-based simulations.

By offering a structured language, detailed analysis, and **automated gameplay execution**, this system enables users to explore the complexities of cooperation, defection, and decision-making in the Prisoner’s Dilemma, bridging the gap between theoretical game models and real-world computational implementations.