/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interpreter;

import AST.MatchStmt;
import AST.Strategy;
import Analyzer.DeterministicRandomGenerator;
import Analyzer.RandomGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author diego
 */
public class Context {
   
    private int roundNumber;
    private int totalRounds;
    private RandomGenerator random; 
    private Map<String, Strategy> strats;  //  Almacena estrategias por ID
    private Map<String, MatchStmt> matches;
    private Map<String, Integer> score;  // Almacena el puntaje de cada partida
    private Map<String, ArrayList<String>> history;
    private String actStrat;
    
    
    public Context(){
        this.matches = new HashMap<>();
        this.strats = new HashMap<>();
        this.score = new HashMap<>();
        this.history = new HashMap<>();
    }

    public String getActStrat() {
        return actStrat;
    }

    public void setActStrat(String actStrat) {
        this.actStrat = actStrat;
    }
    
    
    
    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        if(roundNumber>=0) this.roundNumber = roundNumber;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public void setTotalRounds(int totalRounds) {
        if (totalRounds>=0)this.totalRounds = totalRounds;
    }

    public RandomGenerator getRandom() {
        return random;
    }

    public void setRandom(int seed) {
        this.random = new DeterministicRandomGenerator(seed);
    }
    
    public ArrayList<String> getSelfHistory() {
        Strategy s = strats.get(actStrat);
        return s.getHistory(); 
    }
    
    public ArrayList<String> getOpponentHistory() {
        for (Strategy s2 : strats.values()) {
            if (!s2.getID().equals(actStrat) && s2.isInUse()) {
                return s2.getHistory(); 
            }
        }
        return null;
    }
    public void init(){
        this.totalRounds = 0;
        this.roundNumber = 0;
        score.put("mutual cooperation", 0);
        score.put("mutual defection", 0);
        score.put("betrayal reward", 0);
        score.put("betrayal punishment", 0);
    }
    
    public void runMatch(MatchStmt match){
        totalRounds = match.getRounds();
        
    }
    public void setScore(Map<String, Integer> scoring){
        this.score = scoring;
    }
    public void addStrat(String id, Strategy strat){
        strats.put(id, strat);
    }
    
    public Strategy getStrat(String id){
        return strats.get(id);
    }
    
    public void addMatch(String id, MatchStmt match){
        
        matches.put(id, match);
       
    }
    
    public MatchStmt getMatch(String id){
        
        return matches.get(id);
       
    }
}
