/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST;

import Interpreter.Context;
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
        context.init();
        context.setRandom(seed);
        double r = context.getRandom();
        System.out.println(r);
        double r1 = context.getRandom();
        System.out.println(r1);
        for (String matchId : matchIds) {
            context.setOut("=== Match "+matchId+" ===\n");
            context.setOut("Configuration: \n");
            match = context.getMatch(matchId);
            id1 = match.getS1();
            id2 = match.getS2();
            context.setOut("Strategies: "+id1+" vs "+id2+ "\n");
            context.setTotalRounds(match.getRounds());
            context.setScore(match.getScoring());
            context.setOut("Rounds: "+context.getTotalRounds()+"\n");
            context.setOut("Scoring: \n");
            coop = match.getScoring().get("mutual cooperation");
            defect = match.getScoring().get("mutual defection");
            traitor = match.getScoring().get("betrayal reward");
            betrayed = match.getScoring().get("betrayal punishment");
            context.setOut("\t-Mutual Cooperation: "+coop+"\n");
            context.setOut("\t-Mutual Defection: "+defect+"\n");
            context.setOut("\t-Betrayal: "+traitor+"/"+betrayed+" (traitor/betrayed)"+"\n");
            Strategy strat1 = context.getStrat(id1);
            Strategy strat2 = context.getStrat(id2);
            strat1.setInUse(true);
            strat2.setInUse(true);
            ArrayList<IAST> ifs1;
            ArrayList<IAST> ifs2;
            String result1="";
            String result2="";
            //System.out.println(strat1.getHistory());
            //System.out.println(strat2.getHistory());
            context.setOut("The round-by-round progression:\n");
            for (int i = 1; i <= context.getTotalRounds(); i++) {
                if (i==1) {
                    //System.out.println("Round: "+i+" Strat1: "+strat1.getHistory().get(i-1)+", Strat2: "+strat2.getHistory().get(i-1));
                    context.setOut("Round "+i+": "+id1+"="+strat1.getHistory().get(i-1)+", "+id2+"="+strat2.getHistory().get(i-1)+" ");
                    if (strat1.getHistory().get(i-1).equals("C") && strat2.getHistory().get(i-1).equals("C")) {
                        context.setScore1(coop);
                        context.setScore2(coop);
                        context.setOut("("+coop+"/"+coop+")\n");
                    }else if (strat1.getHistory().get(i-1).equals("D") && strat2.getHistory().get(i-1).equals("D")) {
                        context.setScore1(defect);
                        context.setScore2(defect);
                        context.setOut("("+defect+"/"+defect+")\n");
                    }else if (strat1.getHistory().get(i-1).equals("C") && strat2.getHistory().get(i-1).equals("D")) {
                        context.setScore1(betrayed);
                        context.setScore2(traitor);
                        context.setOut("("+betrayed+"/"+traitor+")\n");
                    }else if (strat1.getHistory().get(i-1).equals("D") && strat2.getHistory().get(i-1).equals("C")) {
                        context.setScore1(traitor);
                        context.setScore2(betrayed);
                        context.setOut("("+traitor+"/"+betrayed+")\n");
                    }
                    context.nextRound();
                    //System.out.println("Round: "+context.getRoundNumber());
                    //System.out.println("Round: "+context.getRoundNumber());
                    continue;
                    
                }
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
            
                context.setOut("Round "+i+": "+id1+"="+result1+", "+id2+"="+result2+" ");
                    if (strat1.getHistory().get(i-1).equals("C") && strat2.getHistory().get(i-1).equals("C")) {
                        context.setScore1(coop);
                        context.setScore2(coop);
                        context.setOut("("+coop+"/"+coop+")\n");
                    }else if (strat1.getHistory().get(i-1).equals("D") && strat2.getHistory().get(i-1).equals("D")) {
                        context.setScore1(defect);
                        context.setScore2(defect);
                        context.setOut("("+defect+"/"+defect+")\n");
                    }else if (strat1.getHistory().get(i-1).equals("C") && strat2.getHistory().get(i-1).equals("D")) {
                        context.setScore1(betrayed);
                        context.setScore2(traitor);
                        context.setOut("("+betrayed+"/"+traitor+")\n");
                    }else if (strat1.getHistory().get(i-1).equals("D") && strat2.getHistory().get(i-1).equals("C")) {
                        context.setScore1(traitor);
                        context.setScore2(betrayed);
                        context.setOut("("+traitor+"/"+betrayed+")\n");
                    }
                
                context.nextRound();
                //System.out.println("Round: "+context.getRoundNumber());
            }
            int Dcounter=0,Ccounter=0;
            context.setOut("Match summary: \n");
            context.setOut(id1+": \n");
            context.setOut("Final points: "+context.getScore1()+"\n");
            for (String s : strat1.getHistory()) {
                if (s.equals("D")) {
                    Dcounter++;
                }else{
                    Ccounter++;
                }
            }
            double percent;
            if (Dcounter!=0) {
                percent=(Ccounter/Dcounter)*100;
            }else{
                percent=Ccounter;
            }
            context.setOut("Cooperations: "+percent+"%\n");
            if (Ccounter!=0) {
                percent=(Dcounter/Ccounter)*100;
            }else{
                percent=Dcounter;
            }
            context.setOut("Defections: "+percent+"%\n");
            Dcounter=0;
            Ccounter=0;
            context.setOut(id2+": \n");
            context.setOut("Final points: "+context.getScore2()+"\n");
            for (String s : strat2.getHistory()) {
                if (s.equals("D")) {
                    Dcounter++;
                }else{
                    Ccounter++;
                }
            }
            if (Dcounter!=0) {
                percent=(Ccounter/Dcounter)*100;
            }else{
                percent=Ccounter;
            }
            context.setOut("Cooperations: "+percent+"%\n");
            if (Ccounter!=0) {
                percent=(Dcounter/Ccounter)*100;
            }else{
                percent=Dcounter;
            }
            context.setOut("Defections: "+percent+"%\n");
            
            System.out.println(context.getOut());
            System.out.println(strat1.getHistory());
            System.out.println(strat2.getHistory());
            context.init();
        }
        
        return null;
    }

    
}
