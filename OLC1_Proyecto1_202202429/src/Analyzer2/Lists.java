/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analyzer2;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Lists {
    private static ArrayList<Token> TokensList = new ArrayList();
    private static ArrayList<error> ErrorsList = new ArrayList();

    public Lists() {
    }
    
    public static void initLists(){
        TokensList = new ArrayList();
        ErrorsList = new ArrayList();
    }
    
    public static void setTokensList(Token t) {
        Lists.TokensList.add(t);
    }
    
    public static void setErrorsList(error e) {
        Lists.ErrorsList.add(e);
    }
    
    
}
