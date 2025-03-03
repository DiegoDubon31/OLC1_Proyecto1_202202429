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
public class Stotal_rounds implements IAST<Integer>{

    public Stotal_rounds() {
    }
    
    @Override
    public Integer interpret(Context context) {
        return context.getTotalRounds();
    }
    
}
