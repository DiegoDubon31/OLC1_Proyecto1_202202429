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
public class Strategy implements IAST<Void>{
    private String ID;
    private String initial;
    private ArrayList<IfStmt> rules; 
    private ArrayList<String> history;
    private boolean inUse;

    public Strategy(String ID, String initial, ArrayList<IfStmt> rules) {
        this.ID = ID;
        this.initial = initial;
        this.rules = rules;
        this.history = new ArrayList<>();
        this.history.add(initial); 
        this.inUse = false;
    }
    
    
    @Override
    public Void interpret(Context context) {
        context.addStrat(ID, this);
        return null;
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

    public ArrayList<IfStmt> getRules() {
        return rules;
    }

    public void setRules(ArrayList<IfStmt> rules) {
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
