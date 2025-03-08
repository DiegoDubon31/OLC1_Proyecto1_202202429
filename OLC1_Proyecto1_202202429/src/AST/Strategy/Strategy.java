/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST.Strategy;

import AST.IAST;
import AST.Random.RandomGenerator;
import Interpreter.Context;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Strategy implements IAST{
    private String ID;
    private String initial;
    private ArrayList<IAST> rules; 
    private IAST elseBranch;
    private ArrayList<String> history;
    private boolean inUse;
    private RandomGenerator random;

    public Strategy(String ID, String initial, ArrayList<IAST> rules) {
        this.ID = ID;
        this.initial = initial;
        this.rules = rules;
        //this.elseBranch = elseBranch;
        this.history = new ArrayList<>();
        //this.history.add(initial); 
        this.inUse = false;
    }
    
    
    @Override
    public Void interpret(Context context) {
        context.addStrat(ID, this);
        return null;
    }
    public void initHistory(){
        history.clear();
    }
    public RandomGenerator getRandom() {
        return random;
    }

    public void setRandom(RandomGenerator random) {
        this.random = random;
    }
    
    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
    
    
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public ArrayList<IAST> getRules() {
        return rules;
    }
    
    public void setRules(ArrayList<IAST> rules) {
        this.rules = rules;
    }
    
    public void addRules(IfStmt r) {
        rules.add(r);
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
    
    public void addHistory(String s) {
        history.add(s);
    }
    
    
}
