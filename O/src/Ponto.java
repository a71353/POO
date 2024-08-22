import java.util.Random;

public class Ponto {
    /**
     * @autor Goncalo Figueiredo
     * @version 1
     * */
    private double x, y;

    /**
     *Este método, é o construtor da classe Ponto.Um ponto leva 2 coordenadas(x,y), e neste caso
     * só podem pertencer ao primeiro quadrante.
     * @param x Coordenada no eixo do x, de cada ponto.
     * @param y Coordenada no eixo do y, de cada ponto.
     * @inv ponto:vi  caso as coordenadas do ponto dado não pertençam ao primeiro quadrante, damos print
     * a informar que ocorreu uma invariante, e terminamos o programa.
     * @return retorna um ponto
     */
    public Ponto(double x,double y) {
        if(x>=0 && y>=0) {
            this.x = x;
            this.y = y;
        }else{
            System.out.println("Ponto:vi");
            System.exit(0);
        }
    }

    /**
     * Cria um generator, que cria pontos aleatórios
     * @param generator é o generator usado
     */
    public Ponto(Random generator){
        this.x = generator.nextInt(100);
        this.y = generator.nextInt(100);
    }

    /**
     * Este método retorna x
     * @return retorna x
     */
    public double getX() {
        return x;
    }
    /**
     * Este método retorna y
     * @return retorna y
     */
    public double getY() {
        return y;
    }

    /**
     * Este método,serve para definifir um valor novo para o x
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Este método,serve para definifir um valor novo para o y
     */

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Este método, calcula a distancia entre 2 pontos,
     * @param p ponto que será usado para calcular a distancia com o ponto fornecido pelo construtor.
     * @return retorna um numero double , que representa a distancia.
     */
    double dist(Ponto p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

}