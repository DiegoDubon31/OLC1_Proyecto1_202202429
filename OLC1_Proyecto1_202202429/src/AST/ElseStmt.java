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
public class ElseStmt implements IAST{
    private IAST action;

    public ElseStmt(IAST action) {
        this.action = action;
    }
    
    @Override
    public String interpret(Context context) {
        Object o = action.interpret(context);
        if (o instanceof String s) {
            return s;
        }
        return null;
    }
    
}
