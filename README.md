# **Prisoner's Dilemma Simulator**

A simulation of the **Prisoner's Dilemma** game using customizable strategies and match configurations.
This project performs **lexical and syntactical analysis** using **JFlex** and **CUP**, builds an **AST** using the design pattern **Interpreter**, and executes matches while generating reports for **lexical errors and tokens**.

**Status:** ✅ Completed

## **Features**
- 📂 Supports `.cmp` files to define strategies and matches.
- 🔍 Lexical & Syntactical Analysis (JFlex & CUP).
- 🌳 Builds and interprets an **AST (Abstract Syntax Tree)**.
- 🎮 Simulates **round-by-round matches** between strategies.
- 📊 Generates **HTML reports** for tokens and lexical errors.

## **Installation**

1. Clone this repository:
   ```sh
   git clone https://gitlab.com/DiegoDubon31/OLC1_Proyecto1_202202429.git
   cd OLC1_Proyecto1_202202429
   ```
   In case you are in github use:
   ```sh
   git clone https://github.com/DiegoDubon31/OLC1_Proyecto1_202202429.git
   cd OLC1_Proyecto1_202202429
   ```

2. Run the program:
   ```sh
   java -jar dist/OLC1_Proyecto1_202202429.jar
   ```

3. If using **NetBeans**, open the project and click `Run`.

## **Files Structure**
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

## **Program View**
**Main Screen**

![Initial Screen](https://i.ibb.co/svHmR7TB/Captura-de-pantalla-2025-03-08-103949.png)

**Running a match**

![Execute Screen](https://i.ibb.co/nMc75Xyx/Captura-de-pantalla-2025-03-08-125157.png)

## **Documentation**
Locate in **📁Manuals** folder in the root: 
```sh
cd ..
cd Manuals
```
You will find the:
- **Technical** and **User** Manuals
- **Grammar** of the Parser in the Back-Naur-Form (BNF)