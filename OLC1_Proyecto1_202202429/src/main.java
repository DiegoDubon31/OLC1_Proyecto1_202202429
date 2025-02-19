
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
                      
                    strategy noRandom {
                        initial: C
                        rules: [
                            if round_number <= 2 then D,
                            if round_number == 3 && get_moves_count(opponent_history, D) == 2 then C,
                            if round_number > 3 && get_last_n_moves(opponent_history, 2) == [D, D] then D,
                            else D
                        ]
                    }
                       
                      match GraaskampvsRandom {
                          players strategies: [Graaskamp, Random]
                          rounds: 100
                          scoring: {
                              mutual cooperation: 3, 
                              mutual defection: 1, 
                              betrayal reward: 5, 
                              betrayal punishment: 0 
                          }
                      }
                      
                      main {
                          run [GraaskampvsRandom] with {
                              seed: 42
                          }
                      }
                       """;
        Lexer scanner = new Lexer(new StringReader(input));
        Parser sintax = new Parser(scanner);
       
        AST root = (AST)sintax.parse().value;
        root.printAST(root,"",true);
    }
    
}
