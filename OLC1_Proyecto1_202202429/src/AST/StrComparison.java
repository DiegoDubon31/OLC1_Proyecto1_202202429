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
public class StrComparison implements IAST<Boolean>{
    
    private IAST<String> side1;
    private String operator;
    private IAST<String> side2;

    public StrComparison(IAST<String> side1, String operator, IAST<String> side2) {
        this.side1 = side1;
        this.operator = operator;
        this.side2 = side2;
    }
    
    
    
    @Override
    public Boolean interpret(Context context) {
        switch (operator){
            case "!=" -> {
                return !side1.interpret(context).equals(side2.interpret(context));
            }
            case "==" -> {
                return side1.interpret(context).equals(side2.interpret(context));
            }
            default -> System.out.println("Error no valid comparison");
            
        }
        return null; 
    }
    
}
