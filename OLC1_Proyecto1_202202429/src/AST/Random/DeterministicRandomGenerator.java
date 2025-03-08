/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST.Random;

import java.util.Random;

/**
 *
 * @author diego
 */
public class DeterministicRandomGenerator implements RandomGenerator{
    private final long originalSeed;
    private Random random;

    public DeterministicRandomGenerator(long seed) {
        this.originalSeed = seed;
        this.random = new Random(seed);
    }
    
    /**
    * Método de fábrica para crear generadores.
    * @param seed Semilla para el generador
    * @return Nuevo generador de números aleatorios
    */
    public static RandomGenerator create(long seed){
        return new DeterministicRandomGenerator(seed);
    }
    
    @Override
    public double nextDouble() {
        return random.nextDouble();
    }
    
    
}
