/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AST;

import Interpreter.Context;

/**
 *
 * @author diego
 * @param <T>
 */

public interface IAST<T> {
    T interpret(Context context);
}
