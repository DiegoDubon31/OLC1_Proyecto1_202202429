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
public class RunStmt implements IAST<Void>{
    public ArrayList<String> matchIds ;
    public int seed;

    public RunStmt(ArrayList<String> matchIds, int seed) {
        this.matchIds = matchIds;
        this.seed = seed;
    }
    
    
    
    @Override
    public Void interpret(Context context) {
        /*MatchStmt match; 
        String id1;
        String id2; 
        context.init();
        context.setRandom(seed);
        for (String matchId : matchIds) {
            match = context.getMatch(matchId);
            context.setTotalRounds(match.getRounds());
            context.setScore(match.getScoring());
            id1 = match.getS1();
            id2 = match.getS2();
            Strategy strat1 = context.getStrat(id1);
            Strategy strat2 = context.getStrat(id2);
            strat1.setInUse(true);
            strat2.setInUse(true);
            context.setActStrat(id1);
            strat1.interpret(context);
            strat2.interpret(context);
        }*/
        for (String matchId : matchIds) {
            MatchStmt match = context.getMatch(matchId);
            String id1 = match.getS1();
            String id2 = match.getS2();
            Strategy strat1 = context.getStrat(id1);
            Strategy strat2 = context.getStrat(id2);
            System.out.println("Match: "+match.getId());
            System.out.println("Strategies in this match: "+match.getS1()+", "+match.getS2());
            System.out.println("Rounds: "+match.getRounds());
            System.out.println("Score of the match: "+match.getScoring());
            System.out.println("STRATS");
            System.out.println("Strat 1: "+strat1.getID());
            System.out.println("Strat 1 initial move: "+strat1.getInitial());
            System.out.println("Strat 2: "+strat2.getID());
            System.out.println("Strat 2 initial move: "+strat2.getInitial());
        }
        System.out.println("RunStmt");
        System.out.print("IDs: "+matchIds);
        
        System.out.println(" Seed: "+seed);
        return null;
    }

    
}
