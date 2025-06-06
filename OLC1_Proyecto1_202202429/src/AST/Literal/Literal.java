/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST.Literal;

import AST.Interpreter.IAST;
import AST.Interpreter.Context;

/**
 *
 * @author diego
 * @param <T>
 */
public class Literal<T> implements IAST {
    private final T value;

    public Literal(T value) {
        this.value = value;
    }
    @Override
    public T interpret(Context context) {
        return value;
    }
    
}
