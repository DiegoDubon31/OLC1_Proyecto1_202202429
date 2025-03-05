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
public class Fget_last_n_moves implements IAST{
    private IAST history;
    private IAST dLst;

    public Fget_last_n_moves(IAST history, IAST dLst) {
        this.history = history;
        this.dLst = dLst;
    }
    
    
    @Override
    public ArrayList<String> interpret(Context context) {
        Object arg1 = history.interpret(context);
        Object arg2 = dLst.interpret(context);
        if (arg1 instanceof String sArg1 && arg2 instanceof Integer iArg2) {
            if (sArg1.equals("self_history")) {
                ArrayList<String> hist = context.getSelfHistory();
                ArrayList<String> aux = new ArrayList<>();
                String decision;
                for (int i = 0; i <= iArg2; i++) {
                    decision = hist.get(i);
                    aux.add(decision);
                }
                return aux;
            }else{
                ArrayList<String> hist = context.getOpponentHistory();
                ArrayList<String> aux = new ArrayList<>();
                String decision;
                for (int i = 0; i <= iArg2; i++) {
                    decision = hist.get(i);
                    aux.add(decision);
                }
                return aux;
            }
        }
        return null;
    }
    
}
