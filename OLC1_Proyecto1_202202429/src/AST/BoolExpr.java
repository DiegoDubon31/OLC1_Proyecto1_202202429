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
public class BoolExpr implements IAST{
    public IAST side1;
    public String operator;
    public IAST side2;

    public BoolExpr(IAST side1, String operator, IAST side2) {
        this.side1 = side1;
        this.operator = operator;
        this.side2 = side2;
    }
    
    
    @Override
    public Boolean interpret(Context context) {
        if (operator == null && side2 == null) {
            Object o = side1.interpret(context);
            if (o instanceof Boolean bool) {
                return bool;
            }
            
        }else{
            switch (operator){
                case "&&" -> {
                    Object o1 = side1.interpret(context);
                    Object o2 = side2.interpret(context);
                    if (o1 instanceof Boolean bool1 && o2 instanceof Boolean bool2) {
                        return bool1 && bool2; 
                    }
                    
                }
                case "||" -> {
                    Object o1 = side1.interpret(context);
                    Object o2 = side2.interpret(context);
                    if (o1 instanceof Boolean bool1 && o2 instanceof Boolean bool2) {
                        return bool1 || bool2; 
                    }
                }
                default -> System.out.println("No valid boolean operation");
            }
        }
        return null;
      
    }
    
}
