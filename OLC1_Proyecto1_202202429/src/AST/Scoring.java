/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST;

import Interpreter.Context;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author diego
 */
public class Scoring implements IAST<Void>{
    private Map<String, Integer> scoring;

    public Scoring() {
        this.scoring = new HashMap<>();
    }
    
    
    @Override
    public Void interpret(Context context) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
