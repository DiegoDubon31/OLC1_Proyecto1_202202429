/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST.Main;

import AST.IAST;
import Interpreter.Context;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class MainStmt implements IAST{
    public ArrayList<RunStmt> runs;

    public MainStmt(ArrayList<RunStmt> runs) {
        this.runs = runs;
    }

    @Override
    public Object interpret(Context context) {
        for (RunStmt run : runs) {
           run.interpret(context);
        }
        return null;
    }
    
    
    
    
}
