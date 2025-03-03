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
public class Flast_move implements IAST<String>{
    private String history;

    public Flast_move(String history) {
        this.history = history;
    }
    
    
    @Override
    public String interpret(Context context) {
        System.out.println("Función last_move de: "+history);
        return "";
    }
    
    
}
