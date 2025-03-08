/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST.Random;

import AST.IAST;
import AST.Strategy.Strategy;
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
        Strategy strat = context.getStrat(context.getActStrat());
        RandomGenerator random = context.getRandom();
        strat.setRandom(random);
        
        return strat.getRandom().nextDouble();
    }
    
}
