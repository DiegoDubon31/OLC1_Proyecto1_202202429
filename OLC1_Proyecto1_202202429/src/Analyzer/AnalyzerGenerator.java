/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analyzer;

import Analyzer.*;

/**
 *
 * @author diego
 */
public class AnalyzerGenerator {
    public static void main(String[] args) {
        generateCompiler();
    }
    public static void generateCompiler() {
        try {
            String ruta = "src/Analyzer/";
            /*
            ruta del archivo jflex
            -d -> ruta donde generar archivo de salida
            ruta de salida
             */

            String opcFlex[] = {ruta + "Lexer.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            /*
            -destdir indica la ruta donde se generara la salida
            ruta de salida
            -parser indican el nombre del archivo
            parser
            ruta del archivo cup
             */
            String opcCup[] = {"-destdir", ruta, "-parser", "Parser", ruta + "Parser.cup"};
            java_cup.Main.main(opcCup);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
