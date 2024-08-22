public class Ponto {
    double x, y;

    Ponto(double x, double y) {

        this.x = x;
        this.y = y;
    }


    double dist (Ponto p) {

        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean verify(){
        return x >= 0 && y >=0;
    }

    public String toString() {
        return "(" + (int)x + ";" + (int)y + ")";
    }
}