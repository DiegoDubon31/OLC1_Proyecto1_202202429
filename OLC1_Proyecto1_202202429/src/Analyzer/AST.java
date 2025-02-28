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

    public AST(String lex) {
        this.lex = lex;
        this.childNodes = new ArrayList<>();
    }
    
    public void addChild(AST child){
        this.childNodes.add(child);
    }
    
    public void run(AST root, ArrayList<SymNode> TS){
        for (AST child : root.childNodes) {
            run(child, TS);
        }
        if (root.lex.equals("STRATEGY")) { //strategy ::= strat ID:0 { strategyArg:1 }
            String strategy = root.childNodes.get(0).lex;
            AST strategyArg = root.childNodes.get(1);
        }
        if (root.lex.equals("MATCH")){  //matches ::= MATCH ID { matchArgs } 
            String matchID = root.childNodes.get(0).lex;
            AST matchArgs = root.childNodes.get(1);
            if (matchArgs.lex.equals("MATCH ARG") && matchArgs.childNodes.size()==4){
                
            }
        }
    }
    
    

    public void printAST(AST root, String prefix, boolean isLast) {
        if (root == null) {
            return;
        }

        // Prefijo para los nodos
        System.out.print(prefix);
        if (isLast) {
            System.out.print("+-- ");
            prefix += "   ";
        } else {
            System.out.print("|-- ");
            prefix += "|  ";
        }

        // Imprimir el nodo actual
        System.out.println(root.lex);

        // Imprimir los hijos recursivamente
        for (int i = 0; i < root.childNodes.size(); i++) {
            printAST(root.childNodes.get(i), prefix, i == root.childNodes.size() - 1);
        }
    }



    
}
