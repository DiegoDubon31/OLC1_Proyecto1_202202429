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
public class Sround_number implements IAST<Integer>{

    public Sround_number() {
    }
    
    
    @Override
    public Integer interpret(Context context) {
        return context.getRoundNumber();
    }
    
}
