/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST;

import Analyzer.RandomGenerator;
import Interpreter.Context;

/**
 *
 * @author diego
 */
public class Srandom implements IAST<RandomGenerator>{

    public Srandom() {
    }
    
    @Override
    public RandomGenerator interpret(Context context) {
        return context.getRandom();
    }
    
}
