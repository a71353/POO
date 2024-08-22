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

    private Double battery;

    private String state;

    private Populacao pop;

    public Robot(PontodeCarga carga, String state, Populacao pop){
        this.p = carga.getPonto();
        this.battery = 100.0;
        this.state = state;
        this.pop = pop;
    }

    /**
     * Recebe um gerador de números aleatórios e uma lista de obstáculos e calcula a melhor trajetória para o robot evitar esses obstáculos.
     * @param generator -Gerador de números aleatórios
     * @param obstaculos -Lista de obstáculos a evitar
     * @return Trajetória calculada
     */
    public Trajetoria path(Random generator, ArrayList<FiguraGeometrica> obstaculos){
        Planeador plan = new Planeador(pop, obstaculos);
        plan.recomb(generator);
        pop.removehits(obstaculos);
        return pop.trajetorias().get(encontrarIndiceMinimo()).addPonto(0, p);
    }

    /**
     * Verifica se o robot tem energia suficiente para concluir uma encomenda, removendo as trajetórias que não satisfazem esta condição.
     */
    public void hasEnoughEnergyToEncomenda(){
        double distance = 0;
        double energyNeeded;
        for(int i = 0; i < pop.trajetorias().size(); i++){
            for(int j = 0; j < pop.trajetorias().get(i).getpontos().size() - 1; j++){
                distance += pop.trajetorias().get(i).getpontos().get(j).dist(pop.trajetorias().get(i).getpontos().get(j+1)) + pop.trajetorias().get(i).getpontos().get(j+1).dist(p);
            }
            energyNeeded = distance * 0.01;
            if(battery < energyNeeded){
                pop.trajetorias().remove(i);
                i++;
            }
        }
    }

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
    public double bateriam(Ponto p, Ponto p1){
        double dist = p.dist(p1);
        battery -= dist*0.05;
        return battery;
    }

    /**
     * @return decrementação da bateria dos robots parados
     */
    public double diminuirBateria() {
        battery -= 0.01;
        return battery;
    }

    /**
     * Encontra o índice da trajetória com menos energia necessária para ser percorrida.
     * @return índice da trajetória com a menor energia necessária
     */
    public int encontrarIndiceMinimo() {
        int indiceMinimo = 0;
        double valorMinimo = energyneeded().get(0);
        for (int i = 1; i < energyneeded().size(); i++) {
            if (energyneeded().get(i) < valorMinimo) {
                valorMinimo = energyneeded().get(i);
                indiceMinimo = i;
            }
        }
        return indiceMinimo;
    }

    /**
     * Calcula a energia necessária para percorrer cada trajetória.
     * @return Lista de energia necessária para cada trajetória.
     */
    public ArrayList<Double> energyneeded(){
        ArrayList<Double> energyneeded = new ArrayList<>();
        double result = 0;
        for(int i = 0; i < pop.trajetorias().size(); i++){
            for(int j = 0; j < pop.trajetorias().get(i).getpontos().size() - 1; j++){
                result += p.dist(pop.trajetorias().get(i).getpontos().get(j)) + pop.trajetorias().get(i).getpontos().get(j).dist(pop.trajetorias().get(i).getpontos().get(j+1)) + pop.trajetorias().get(i).getpontos().get(j+1).dist(p);
            }
            energyneeded.add(i, result * 0.01);
            result = 0;
        }
        return energyneeded;
    }

}
