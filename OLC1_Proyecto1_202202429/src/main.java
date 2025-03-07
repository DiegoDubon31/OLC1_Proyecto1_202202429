
import AST.IAST;
import Analyzer.AST;
import AST.DeterministicRandomGenerator;
import Analyzer2.Lexer;
import Analyzer.Parser;
import AST.RandomGenerator;
import Analyzer2.Parser2;
import Interpreter.Context;
import java.io.StringReader;
import java.util.ArrayList;
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
                       strategy Graaskamp {
                           initial: D
                           rules: [
                               if round_number <= 2 then D,
                               if round_number == 3 && get_moves_count(opponent_history, D) == 2 then C,
                               if round_number > 3 && get_last_n_moves(opponent_history, 2) == [D, D] then D,
                               else last_move(opponent_history)
                           ]
                       }
                       
                       strategy Random {
                           initial: C
                           rules: [
                               if random < 0.5 then C,
                               else D
                           ]
                       }
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
                       match GraaskampvsAlwaysCooperate {
                           players strategies: [Graaskamp, AlwaysCooperate]
                           rounds: 100
                           scoring: {
                               mutual cooperation: 3, 
                               mutual defection: 1, 
                               betrayal reward: 5, 
                               betrayal punishment: 0 
                           }
                       }
                       match RandomvsAlwaysDefect {
                                                  players strategies: [Random, AlwaysDefect]
                                                  rounds: 100
                                                  scoring: {
                                                      mutual cooperation: 3, 
                                                      mutual defection: 1, 
                                                      betrayal reward: 5, 
                                                      betrayal punishment: 0 
                                                  }
                                              }
                       match RandomvsAlwaysCooperate {
                                                                         players strategies: [Random, AlwaysCooperate]
                                                                         rounds: 100
                                                                         scoring: {
                                                                             mutual cooperation: 3, 
                                                                             mutual defection: 1, 
                                                                             betrayal reward: 5, 
                                                                             betrayal punishment: 0 
                                                                         }
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
                           run [GraaskampvsRandom, ADefectvsACoop] with {
                               seed: 42
                           }
                            run [GraaskampvsRandom, GraaskampvsAlwaysCooperate, RandomvsAlwaysDefect, RandomvsAlwaysCooperate] with {
                                 seed: 69
                             }
                       }
                           
                       """;
        Lexer scanner = new Lexer(new StringReader(input));
        Parser2 sintax = new Parser2(scanner);
       
        sintax.parse();
        ArrayList<IAST> AST = sintax.AST;
        Context context = new Context();
        for (IAST iast : AST) {
            iast.interpret(context);
            
        }
        
        /*RandomGenerator gen1 = DeterministicRandomGenerator.create(42);
        RandomGenerator gen2 = DeterministicRandomGenerator.create(42);
        printGenerator("1", gen1);
        printGenerator("1", gen1);
        printGenerator("2", gen2);
        printGenerator("1", gen1);
        printGenerator("2", gen2);
        printGenerator("1", gen1);
        printGenerator("2", gen2);
        printGenerator("2", gen2);
        printGenerator("1", gen1);
        printGenerator("1", gen1);
        printGenerator("2", gen2);
        printGenerator("1", gen1);
        printGenerator("2", gen2);
        printGenerator("1", gen1);
        printGenerator("2", gen2);
        printGenerator("2", gen2);*/



    }
    /**
    * Imprimir números generados.
    * @param id Identificador del generador
    * @param gen Generador de números pseudo-aleatorios
    */
    private static void printGenerator(String id, RandomGenerator gen){
        System.out.println("Generador: " + id + ", a lanzado el número: " +
        gen.nextDouble());
    }
    
}
