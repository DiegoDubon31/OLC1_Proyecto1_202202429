/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analyzer;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class AST {
    public String lex;
    public ArrayList<AST> childNodes;
    public Object result;

    public AST(String lex, ArrayList<AST> childNodes, Object result) {
        this.lex = lex;
        this.childNodes = new ArrayList<>();
        this.result = result;
    }
    
    public void addChild(AST child){
        this.childNodes.add(child);
    }
    
    public void run(AST root, ArrayList<SymNode> TS){
        for (AST child : root.childNodes) {
            run(child, TS);
        }
    }
    public void printAST(AST root, String indent) {
        if (root == null) {
            return;
        }
        
        // Imprime el nodo actual con la indentación apropiada
        System.out.println(indent + root.lex);
        
        // Incrementa la indentación para los hijos
        for (AST hijo : root.childNodes) {
            printAST(hijo, indent + "   ");
        }
    }
    
}
