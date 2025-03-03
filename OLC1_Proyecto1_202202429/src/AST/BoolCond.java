/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST;

import Interpreter.Context;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class BoolCond implements IAST<Boolean>{
    public IAST<?> side1;
    public String operator;
    public IAST<?> side2;

    public BoolCond(IAST<?> side1, String operator, IAST<?> side2) {
        this.side1 = side1;
        this.operator = operator;
        this.side2 = side2;
    }
    
    
    @Override
    public Boolean interpret(Context context) {
        Object value1 = side1.interpret(context);
        Object value2 = side2.interpret(context);

        if (value1 instanceof Number && value2 instanceof Number) {
            double num1 = ((Number) value1).doubleValue();
            double num2 = ((Number) value2).doubleValue();
            
            switch (operator) {
                case "==" -> {
                    return num1 == num2;
                }
                case "!=" -> {
                    return num1 != num2;
                }
                case ">" -> {
                    return num1 > num2;
                }
                case "<" -> {
                    return num1 < num2;
                }
                case ">=" -> {
                    return num1 >= num2;
                }
                case "<=" -> {
                    return num1 <= num2;
                }
                default -> throw new RuntimeException("Unknown operator: " + operator);
            }
        }else if (value1 instanceof String && value2 instanceof String) {
            String s1 = (String) value1;
            String s2 = (String) value2;
            switch (operator) {
                case "==" -> {
                    return s1.equals(s2);
                }
                case "!=" -> {
                    return !s1.equals(s2);
                }
                default -> throw new RuntimeException("Unknown operator: " + operator);

            }
        }else if (value1 instanceof ArrayList<?> && value2 instanceof ArrayList<?>) { // 🔹 Comparación de listas
            ArrayList<String> lista1 = (ArrayList<String>) value1;
            ArrayList<String> lista2 = (ArrayList<String>) value2;

            switch (operator) {
                case "==" -> { return lista1.equals(lista2); }
                case "!=" -> { return !lista1.equals(lista2); }
                default -> throw new RuntimeException("Operador desconocido para listas: " + operator);
            }
        }
        return null;
    }
    
}
