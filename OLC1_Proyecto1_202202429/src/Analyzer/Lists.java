/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analyzer;

import java.io.FileWriter;
import java.io.PrintWriter;
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

    public static ArrayList<Token> getTokensList() {
        return TokensList;
    }

    public static ArrayList<error> getErrorsList() {
        return ErrorsList;
    }
    
    public static void setTokensList(Token t) {
        Lists.TokensList.add(t);
    }
    
    public static void setErrorsList(error e) {
        Lists.ErrorsList.add(e);
    }
    
    public static void generarTablaHTMLTokens() {
        
        StringBuilder tabla = new StringBuilder();
       tabla.append("<h2>").append("Tokens").append("</h2>\n");
        // Inicio de la tabla
        tabla.append("<table border=\"1\">\n");
        int i = 1;
        // Encabezados de la tabla
        tabla.append("<tr>");
        tabla.append("<th>#</th>");
        tabla.append("<th>Lexeme</th>");
        tabla.append("<th>Type</th>");
        tabla.append("<th>Line</th>");
        tabla.append("<th>Column</th>");
        tabla.append("</tr>\n");

        // Agregar datos a la tabla
        for (Token t : TokensList) {
            tabla.append("<tr>");
            tabla.append("<td>").append(String.valueOf(i)).append("</td>");
            tabla.append("<td>").append(t.getLexeme()).append("</td>");
            tabla.append("<td>").append(t.getType()).append("</td>");
            tabla.append("<td>").append(t.getRow()).append("</td>");
            tabla.append("<td>").append(t.getColumn()).append("</td>");
            i++;
            tabla.append("</tr>\n");
        }

        // Fin de la tabla
        tabla.append("</table>");

         escribirArchivoHTML("./reports/Tokens.html", tabla.toString());
    }
    
    public static void generarTablaHTMLErrores() {
        
        StringBuilder tabla = new StringBuilder();
       tabla.append("<h2>").append("Errors").append("</h2>\n");
        // Inicio de la tabla
        int i = 1;
        tabla.append("<table border=\"1\">\n");

        // Encabezados de la tabla
        tabla.append("<tr>");
        tabla.append("<th>#</th>");
        tabla.append("<th>Type</th>");
        tabla.append("<th>Description</th>");
        tabla.append("<th>Line</th>");
        tabla.append("<th>Column</th>");
        tabla.append("</tr>\n");

        // Agregar datos a la tabla
        for (error e : ErrorsList) {
            tabla.append("<tr>");
            tabla.append("<td>").append(String.valueOf(i)).append("</td>");
            tabla.append("<td>").append(e.getType()).append("</td>");
            tabla.append("<td>").append(e.getLexeme()).append("</td>");
            tabla.append("<td>").append(e.getRow()).append("</td>");
            tabla.append("<td>").append(e.getColumn()).append("</td>");
            
            tabla.append("</tr>\n");
            i++;
        }

        // Fin de la tabla
        tabla.append("</table>");

         escribirArchivoHTML("./reports/Errors.html", tabla.toString());
    }
    
    public static void escribirArchivoHTML(String rutaArchivo, String contenidoHTML) {
    try {
            FileWriter fileWriter = new FileWriter(rutaArchivo);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(contenidoHTML);

            printWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       
    
}
