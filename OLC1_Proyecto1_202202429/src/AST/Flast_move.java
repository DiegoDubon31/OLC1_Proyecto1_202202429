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
public class Flast_move implements IAST{
    private IAST history;

    public Flast_move(IAST history) {
        this.history = history;
    }
    
    
    @Override
    public String interpret(Context context) {
        Object arg1 = history.interpret(context);
        if (arg1 instanceof String sArg) {
            if (sArg.equals("self_history")) {
                ArrayList<String> hist = context.getSelfHistory();
                return hist.get(hist.size()-1);
            }else{
                ArrayList<String> hist = context.getOpponentHistory();
                return hist.get(hist.size()-1);
            }
        }
        return null;
    }
    
    
}
