import java.util.Random;

public class Generator {
    private Random generator;

    /**
     * Cria um novo gerador aleatório com base em uma semente fornecida.
     *
     * @param seed a semente utilizada pelo gerador aleatório.
     */
    public Generator(long seed) {
        generator = new Random(seed);
    }

    /**
     * Gera um número aleatório inteiro no intervalo de 0 a (limite-1).
     * @param limite
     * @return
     */
    public int Nextint(int limite) {
        return generator.nextInt(limite);
    }
}
