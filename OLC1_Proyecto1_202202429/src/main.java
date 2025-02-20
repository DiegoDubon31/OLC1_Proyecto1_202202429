
import Analyzer.AST;
import Analyzer.Lexer;
import Analyzer.Parser;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        String input = """
                      strategy SmartStrategy {
                          initial: D
                          rules: [
                              if get_moves_count(opponent_history, last_move(opponent_history)) == get_moves_count(opponent_history, D) then C,
                              else last_move(opponent_history)
                          ]
                      }
                      
                      strategy Random50 {
                          initial: C
                          rules: [
                              if random < 0.5 then C,
                              else D
                          ]
                      }
                      
                      match SmartVsRandom {
                          players strategies: [SmartStrategy, Random50]
                          rounds: 75
                          scoring: {
                              mutual cooperation: 3,
                              mutual defection: 1,
                              betrayal reward: 5,
                              betrayal punishment: 0
                          }
                      }
                      
                      main {
                          run [SmartVsRandom] with {
                              seed: 321
                          }
                      }
                       """;
        Lexer scanner = new Lexer(new StringReader(input));
        Parser sintax = new Parser(scanner);
       
        AST root = (AST)sintax.parse().value;
        root.printAST(root,"",true);
    }
    
}
