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
public class Logical implements IAST<Boolean>{
    
    private IAST<Boolean> side1;
    private String operator;
    private IAST<Boolean> side2;

    public Logical(IAST<Boolean> side1, String operator, IAST<Boolean> side2) {
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
