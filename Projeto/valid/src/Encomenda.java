/**
 * A classe Encomenda é uma classe que representa uma encomenda a ser entregue, contendo informações sobre o ponto inicial da encomenda e o ponto final é onde a encomenda deve ser entregue.
 * @author António Afonso 71351
 * @author Gonçalo Figueiredo 71353
 * @version 05/05/2023
 */

public class Encomenda {

    private Ponto inicio;
    private Ponto fim;

    public Encomenda(Ponto inicio, Ponto fim) {
        this.inicio = inicio;
        this.fim = fim;
    }
    /**
     * O metodo getFim retorna o ponto fim da encomenda
     * @return um objeto Ponto que representa o ponto de fim da encomenda.
     */
    public Ponto getFim() {
        return fim;
    }
    /**
     * O método getInicio retorna o ponto de início da encomenda
     * @return um objeto Ponto que representa o ponto de inicío da encomenda.
     */
    public Ponto getInicio() {
        return inicio;
    }

}
