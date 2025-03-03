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
public class Fget_last_n_moves implements IAST<String>{
    private String history;
    private String dLst;

    public Fget_last_n_moves(String history, String dLst) {
        this.history = history;
        this.dLst = dLst;
    }
    
    
    @Override
    public String interpret(Context context) {
        System.out.println("get_last_n_moves: "+history+" de: "+dLst);
        return "";
    }
    
}
