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
public class IfStmt implements IAST<String>{
    private IAST<Boolean> expr;
    private IAST<?> thenBranch;
    private IAST<?> elseBranch;
    
    public IfStmt(IAST<Boolean> expr, IAST<?> thenBranch, IAST<?> elseBranch) {
        this.expr = expr;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    
    @Override
    public String interpret(Context context) {
        if (expr != null) {
            System.out.println("Condicion: "+ expr.interpret(context));
        }else{
            System.out.println("Else: "+ elseBranch.interpret(context));
        }
        return null;
    }
    
}
