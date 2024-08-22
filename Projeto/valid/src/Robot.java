import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Esta classe representa um robot capaz de planear e executar trajetórias numa dada população de indivíduos.
 * O robot tem um ponto de carga, uma bateria, um estado e uma população de trajetorias.
 * @author António Afonso 71351
 * @author Gonçalo Figueiredo 71353
 * @version 06/05/2023
 * @inv o valor de bateria do robot deve estar entre 0 e 100
 */
public class Robot {

    private Ponto p;

    private Integer battery;

    private String state;




    private ArrayList<Ponto> pontos;

    public Robot(Ponto p, Integer battery){
        this.p = p;
        this.battery = battery;
    }

    public void setPontos(ArrayList<Ponto> pontos) {
        this.pontos = pontos;
    }

    /**
     * Recebe um gerador de números aleatórios e uma lista de obstáculos e calcula a melhor trajetória para o robot evitar esses obstáculos.
     * @param generator -Gerador de números aleatórios
     * @param obstaculos -Lista de obstáculos a evitar
     * @return Trajetória calculada
     */


    /**
     * Verifica se o robot tem energia suficiente para concluir uma encomenda, removendo as trajetórias que não satisfazem esta condição.
     */


    public double battery(){
        return battery;
    }

    public Ponto p(){
        return p;
    }

    /**
     * @param p ponto inicial
     * @param p1 ponto final
     * @return nivel de bateria apos a movimentação de um ponto para outro
     */

    /**
     * @return decrementação da bateria dos robots parados
     */


    /**
     * Encontra o índice da trajetória com menos energia necessária para ser percorrida.
     * @return índice da trajetória com a menor energia necessária
     */


    /**
     * Calcula a energia necessária para percorrer cada trajetória.
     * @return Lista de energia necessária para cada trajetória.
     */


    public Double batteryNeeded() {
        double energy;
        double dist = 0.0;
        Ponto pontoInicial = p;
        dist += pontoInicial.dist(pontos.get(0));
        for (int i = 0; i < pontos.size() - 1; i++) {
            Ponto pontoAtual = pontos.get(i);
            Ponto pontoProximo = pontos.get(i + 1);
            dist += pontoAtual.dist(pontoProximo);
        }
        energy = dist*10;
        return energy;
    }
}
