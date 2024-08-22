/**
 * @author 71353 Gonçalo Figueiredo
 * @inv x e y no primeiro quadrante
 */
public class Ponto {
    double x, y;

    /**
     * @param x
     * @param y
     */
    Ponto(double x, double y) {

        this.x = x;
        this.y = y;
    }

    /**
     * @param p
     * @return retorna a distancia de um ponto a outro
     */
    double dist (Ponto p) {

        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean verify(){
        return x >= 0 && y >=0;
    }
}