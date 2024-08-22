import java.util.ArrayList;
import java.util.Random;

/**
 * A classe Planeador é responsável por realizar o planejamento das trajetórias dos robots.
 * @author Gonçalo Figueiredo 71353
 * @version 5/04/2023
 */
public class Planeador {


    private Populacao pop;

    private ArrayList<FiguraGeometrica> obstaculos;

    /**
     * O construtor Planeador cria um objeto Planeador com uma população inicial e uma lista de obstáculos especificados
     * @param pop -um objeto Populacao que contém a população inicial de trajétorias planejadas.
     * @param obstaculos -um objeto ArrayList que contém a lista de obstáculos a serem evitados pelas trajetórias planejadas.
     */
    public Planeador(Populacao pop, ArrayList<FiguraGeometrica> obstaculos){
        this.pop = pop;
        this.obstaculos = obstaculos;
    }

    /**
     * O método recomb executa o processo de recombinação, seleção, mutação e adição de trajétorias na população atual para gerar uma nova população de trajetórias planejadas.
     * @param generator - um objeto Random usado para gerar números aleatórios durante o processo de recombinação e mutação.
     */
    public void recomb(Random generator){
        pop.removehits(obstaculos);
        pop.orden(generator, obstaculos);
        //pop.cortada(generator, pop);
        pop.mutation(generator, generator.nextDouble(1));
        pop.adition(generator, generator.nextDouble(1));
        pop.remove(generator, generator.nextDouble(1));
    }

}
