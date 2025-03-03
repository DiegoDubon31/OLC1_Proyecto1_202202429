/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST;

import Interpreter.Context;

/**
 *
 * @author diego
 */
public class Action implements IAST<String>{

    private String action;

    public Action(String action) {
        this.action = action;
    }
    
    
    
    @Override
    public String interpret(Context context) {
        return action;
    }
}
