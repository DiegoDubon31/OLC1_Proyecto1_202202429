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
public class Fget_move implements IAST<String>{
    private String history;
    private int n;

    public Fget_move(String history, int n) {
        this.history = history;
        this.n = n;
    }
    
    
    
    @Override
    public String interpret(Context context) {
        System.out.println("Funcion get_move en: "+history+" en posición: "+n);
        return "";
    }
    
}
