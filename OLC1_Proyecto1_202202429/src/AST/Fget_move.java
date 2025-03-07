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
public class Fget_move implements IAST{
    private IAST history;
    private IAST n;

    public Fget_move(IAST history, IAST n) {
        this.history = history;
        this.n = n;
    }
    
    
    
    @Override
    public String interpret(Context context) {
        Object arg1 = history.interpret(context);
        Object arg2 = n.interpret(context);
        
        
        if (arg1 instanceof String sArg && arg2 instanceof Integer iArg) {
            
            if (arg1.equals("self_history")) {
                ArrayList<String> hist = context.getSelfHistory();
                if (iArg>hist.size()) {
                    return null;
                }else{
                    return hist.get(iArg);
                }
            }else{
                ArrayList<String> hist = context.getOpponentHistory();
                if (iArg>hist.size()) {
                    return null;
                }else{
                    return hist.get(iArg);
                }
                
            }
        }
        return null;
        
    }
    
}
