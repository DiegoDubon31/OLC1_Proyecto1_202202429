/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST.Main;

import AST.Interpreter.IAST;
import AST.Match.MatchStmt;
import AST.Strategy.Strategy;
import AST.Interpreter.Context;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class RunStmt implements IAST{
    public ArrayList<String> matchIds ;
    public int seed;

    public RunStmt(ArrayList<String> matchIds, int seed) {
        this.matchIds = matchIds;
        this.seed = seed;
    }
    
    
    
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

                context.setOut("The round-by-round progression:\n");
                for (int i = 1; i <= context.getTotalRounds(); i++) {
                    if (i==1) {
                        //System.out.println("Round: "+i+" Strat1: "+strat1.getHistory().get(0)+", Strat2: "+strat2.getHistory().get(0));
                        strat1.addHistory(strat1.getInitial());
                        strat2.addHistory(strat2.getInitial());

                        if (strat1.getHistory().get(0).equals("C") && strat2.getHistory().get(0).equals("C")) {
                            context.setScore1(coop);
                            context.setScore2(coop);
                            context.setOut("Round "+i+": "+id1+"=COOPERATE, "+id2+"=COOPERATE ");
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
                    //context.nextRound();
                    context.setActStrat(id1);
                    ifs1 = strat1.getRules();
                    for (IAST If1 : ifs1) {
                        result1 = (String)If1.interpret(context);
                        if (result1 != null) {
                            break;
                        }

                    }


                    context.setActStrat(id2);
                    ifs2 = strat2.getRules();
                    for (IAST If2 : ifs2) {
                        result2 = (String)If2.interpret(context);
                        if (result2 != null) {
                            break;
                        }

                    }
                    strat1.addHistory(result1);
                    strat2.addHistory(result2);
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
                //System.out.println(strat1.getHistory());
                //System.out.println(strat2.getHistory());
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
        
}

