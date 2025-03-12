/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST.Functions;

import AST.Interpreter.IAST;
import AST.Interpreter.Context;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Fget_moves_count implements IAST{
    private IAST history;
    private IAST action;

    public Fget_moves_count(IAST history, IAST action) {
        this.history = history;
        this.action = action;
    }

    @Override
    public Integer interpret(Context context) {
        Object arg1 = history.interpret(context);
        Object arg2 = action.interpret(context);
        
        if (arg1 instanceof String sArg1 && arg2 instanceof String sArg2) {
            if (arg1.equals("self_history")) {
                ArrayList<String> hist = context.getSelfHistory();
                String decision;
                int counter=0;
                
                for (int i = 0; i < hist.size(); i++) {
                    decision = hist.get(i);
                    if (decision.equals(sArg2)) {
                       counter++; 
                    }
                }
                return counter;
            }else{
                ArrayList<String> hist = context.getOpponentHistory();
                String decision;
                int counter=0;
                for (int i = 0; i < hist.size(); i++) {
                    decision = hist.get(i);
                    if (decision.equals(sArg2)) {
                       counter++; 
                    }
                }
                return counter;
            }
        }else if (arg1 instanceof ArrayList<?> arr && arg2 instanceof String sArg2) {
            int counter=0;
            String decision;
            for (int i = 0; i < arr.size(); i++) {
                decision = (String) arr.get(i);
                if (decision.equals(sArg2)) {
                   counter++; 
                }
            }
            return counter;
        }
        return null;
    }
    
    
}
