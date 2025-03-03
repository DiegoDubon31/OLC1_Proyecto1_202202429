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
public class Fget_moves_count implements IAST<String>{
    private String history;
    private String action;

    public Fget_moves_count(String history, String action) {
        this.history = history;
        this.action = action;
    }

    @Override
    public String interpret(Context context) {
        System.out.println("Func get_moves_count en: "+history+" contar: "+action);
        return "";
    }
    
    
}
