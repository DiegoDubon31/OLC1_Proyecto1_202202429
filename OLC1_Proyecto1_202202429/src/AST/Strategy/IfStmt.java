/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST.Strategy;

import AST.IAST;
import Interpreter.Context;

/**
 *
 * @author diego
 */
public class IfStmt implements IAST{
    private IAST expr;
    private IAST thenBranch;
    private boolean isIf;
    
    public IfStmt(IAST expr, IAST thenBranch) {
        this.expr = expr;
        this.thenBranch = thenBranch;
    }

    public IfStmt(IAST thenBranch) {
        this.thenBranch = thenBranch;
    }
    
    
    
    @Override
    public String interpret(Context context) {
        /*isIf = false;
        if (expr != null) {
            Object exp = expr.interpret(context);
            if (exp instanceof Boolean isTrue) {
                if (isTrue) {
                    Object then = thenBranch.interpret(context);
                    if (then instanceof String s) {
                        isIf = true;
                        return s;
                    }
                }    
            }
        }else if(!isIf){
            Object then = thenBranch.interpret(context);
            if (then instanceof String s1) {
                return s1;
            }
        }*/
        Object exp = expr.interpret(context);

        if (exp instanceof Boolean isTrue && isTrue) {
            
            Object then = thenBranch.interpret(context);
            if (then instanceof String s) {
                return s;
            }
            
        }

        return null;
    }

    public IAST getThenBranch() {
        return thenBranch;
    }

    public void setThenBranch(IAST thenBranch) {
        this.thenBranch = thenBranch;
    }
    
    public boolean isIsIf() {
        return isIf;
    }

    public void setIsIf(boolean isIf) {
        this.isIf = isIf;
    }
    
    
    
}
