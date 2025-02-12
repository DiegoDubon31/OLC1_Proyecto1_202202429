
import Analyzer.Lexer;
import Analyzer.Parser;
import java.io.StringReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author diego
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String input = """
                       strategy AlwaysDefect {
                           initial: D
                           rules: [
                               else D
                           ]
                       }
                       
                       strategy AlwaysCooperate {
                           initial: C
                           rules: [
                               else C
                           ]
                       }
                       
                       match ADefectvsACoop {
                           players strategies: [AlwaysDefect, AlwaysCooperate]
                           rounds: 100
                           scoring: {
                               mutual cooperation: 3, 
                               mutual defection: 1, 
                               betrayal reward: 5, 
                               betrayal punishment: 0 
                           }
                       }
                       
                       main {
                           run [ADefectvsACoop] with {
                               seed: 42
                           }
                       }
                       """;
        Lexer scanner = new Lexer(new StringReader(input));
        Parser sintax = new Parser(scanner);
    }
    
}
