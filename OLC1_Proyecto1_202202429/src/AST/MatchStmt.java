/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST;

import Interpreter.Context;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author diego
 */
public class MatchStmt implements IAST{
    private String id; 
    private String  s1;
    private String s2;
    private int rounds;
    private Map<String, Integer> scoring;

    public MatchStmt(String id, String s1, String s2, int rounds) {
        this.id = id;
        this.s1 = s1;
        this.s2 = s2;
        this.rounds = rounds;
        this.scoring = new HashMap<>();
        scoring.put("mutual cooperation", 0);
        scoring.put("mutual defection", 0);
        scoring.put("betrayal reward", 0);
        scoring.put("betrayal punishment", 0);
    }

    @Override
    public Void interpret(Context context) {
        context.addMatch(id, this);
        /*System.out.println("MatchStmt: "+id+
                            " Strategies: "+s1+", "+s2+
                            " Rounds: "+rounds+
                            " scoring: "+scoring);
        Strategy strat1 = context.getStrat(s1);
        Strategy strat = context.getStrat(s2);*/
        
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public Map<String, Integer> getScoring() {
        return scoring;
    }

    public void setScoring(String key, int value) {
        if (scoring.containsKey(key)) {
            scoring.put(key, value);
        } else {
            throw new IllegalArgumentException("Scoring key not valid: " + key);
        }
    }
    
    
    
    
}
