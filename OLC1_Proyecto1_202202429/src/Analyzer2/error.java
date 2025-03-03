/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analyzer2;


/**
 *
 * @author diego
 */
public class error extends Token{
    
    public error(String lexeme, String row, String column, String type) {
        super(lexeme, row, column, type);
    }
    
}
