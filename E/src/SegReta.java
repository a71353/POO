public class SegReta {

    private Ponto p1;

    private Ponto p2;

    public SegReta(Ponto p1, Ponto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Ponto getP1() {
        return p1;
    }

    public Ponto getP2() {
        return p2;
    }

    public boolean verseg() {
        return p1.x != p2.x || p1.y != p2.y;
    }

    public boolean interceta(SegReta s) {
        if (p1.x == p2.x) {//se o lado do retangulo for vertical
            double m = (s.p2.y - s.p1.y) / (s.p2.x - s.p1.x);

            double b = s.p1.y - m * s.p1.x;

            double y = m * p1.x + b;

            Ponto inter = new Ponto(p1.x, y);

            return (inter.y >= Math.min(p1.y, p2.y) && inter.y <= Math.max(p1.y, p2.y) && inter.x >= Math.min(s.p1.x, s.p2.x) && inter.x <= Math.max(s.p1.x, s.p2.x));
        } else {
            double m1 = (p2.y - p1.y) / (p2.x - p1.x);
            double m2 = (s.p2.y - s.p1.y) / (s.p2.x - s.p1.x);
            if (m1 == m2 && p1.x != s.p1.x) {
                return false;
            }
            double b1 = p1.y - m1 * p1.x;
            double b2 = s.p1.y - m2 * s.p1.x;

            double x = (b2 - b1) / (m1 - m2);
            double y = m1 * x + b1;

            Ponto inter = new Ponto(x, y);

            return (inter.x <= Math.max(p1.x, p2.x) && inter.x >= Math.min(p1.x, p2.x)
                    && inter.y <= Math.max(p1.y, p2.y) && inter.y >= Math.min(p1.y, p2.y)
                    && inter.x <= Math.max(s.p1.x, s.p2.x) && inter.x >= Math.min(s.p1.x, s.p2.x)
                    && inter.y <= Math.max(s.p1.y, s.p2.y) && inter.y >= Math.min(s.p1.y, s.p2.y));
        }
    }
}

