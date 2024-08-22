public class Ponto {
    double x, y;

    /**
     *
     * @param x
     * @param y
     */
    Ponto(double x, double y) {

        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param p
     * @return distancia entre 2 pontos
     */
    double dist (Ponto p) {

        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     *
     * @return true se for um ponto valido
     */
    public boolean verify(){
        return x >= 0 && y >=0;
    }

    /**
     *
     * @param p
     * @return true se os pontos forem iguais
     */
    public boolean equalsponto(Ponto p){
        return x == p.x && y == p.y;
    }

    /**
     *
     * @return ponto no formato (x;y)
     */

    public String toString() {
        return "(" + (int)x + ";" + (int)y + ")";
    }
}