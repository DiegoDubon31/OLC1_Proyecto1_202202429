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
public class BoolExpr implements IAST<Boolean>{
    public IAST<Boolean> side1;
    public String operator;
    public IAST<Boolean> side2;

    public BoolExpr(IAST<Boolean> side1, String operator, IAST<Boolean> side2) {
        this.side1 = side1;
        this.operator = operator;
        this.side2 = side2;
    }
    
    
    @Override
    public Boolean interpret(Context context) {
        switch (operator){
            case "&&" -> {
                return side1.interpret(context) && side2.interpret(context);
            }
            case "||" -> {
                return side1.interpret(context) || side2.interpret(context);
            }
            default -> System.out.println("No valid boolean operation");
        }
        return null;
      
    }
    
}
