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
public class Srandom implements IAST{

    public Srandom() {
    }
    
    @Override
    public Double interpret(Context context) {
        
        return context.getRandom();
    }
    
}
