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
public class Function implements IAST<Void>{
    private String name;
    private IAST<?> arg1;
    private IAST<?> arg2;

    public Function(String name, IAST<?> arg1, IAST<?> arg2) {
        this.name = name;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public Function(String name, IAST<?> arg1) {
        this.name = name;
        this.arg1 = arg1;
    }
    
    
    
    @Override
    public Void interpret(Context context) {
        Object o1 = arg1.interpret(context);
        if (arg2 != null) {
            Object o2 = arg2.interpret(context);
        }
        
        return null;
    }
    
}
