// File: Ponto.java
class Ponto {
    double x, y;

    Ponto(double x, double y) {
        if(x < 0 || y < 0) {
            System.out.println("iv");
            System.exit(0);
        }
        else {
            this.x = x;
            this.y = y;
        }
    }


    double dist (Ponto p) {

            double dx = x - p.x;
            double dy = y - p.y;
            return Math.sqrt(dx * dx + dy * dy);
    }
}