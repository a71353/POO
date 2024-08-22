/**
 * A classe PontodeCarga é responsável por representar o ponto de carga dos robots.
 * @author António Afonso 71351
 * @author Gonçalo Figueiredo 71353
 * @version 05/05/2023
 */

public class PontodeCarga {

    private Ponto p1;

    /**
     * O construtor PontodeCarga cria um objeto PontodeCarga com um unico ponto.
     * @param p1 - um objeto Ponto que representa o ponto de carga.
     */
    public PontodeCarga(Ponto p1){
        this.p1 = p1;
    }

    /**
     * O método getPonto retorna o ponto de carga.
     * @return um objeto Ponto que representa o ponto de carga associado a este objeto PontodeCarga.
     */
    public Ponto getPonto() {
        return this.p1;
    }
}
