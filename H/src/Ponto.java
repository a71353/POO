public class Ponto {
    double x, y;

    Ponto(double x, double y) {

        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return retorna os pontos no formato "(x;y)"
     */
    public String toString() {
        return "(" + (int)x + ";" + (int)y + ")";
    }
}