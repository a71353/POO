/**
 * @author 71353 Gonçalo Figueiredo
 * @inv o x ou o y tem que ser diferentes nos 2 pontos
 */
public class SegReta{

    private Ponto p1;

    private Ponto p2;

    /**
     * @param p1
     * @param p2
     */
    public SegReta(Ponto p1, Ponto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     *
     * @return retorna ponto1
     */
    public Ponto getP1() {
        return p1;
    }

    /**
     *
     * @return retorna ponto2
     */
    public Ponto getP2() {
        return p2;
    }

    public boolean verseg() {
        return p1.x != p2.x || p1.y != p2.y;
    }

    /**
     * @param s
     * @return retorna true se o segmento de reta intersetar o outro
     */
    public boolean intercetarect(SegReta s) {
        if (p1.x == p2.x) {//se o lado do retangulo for vertical
            double m = (s.getP2().y - s.getP1().y) / (s.getP2().x - s.getP1().x);

            double b = s.getP1().y - m * s.getP1().x;

            double y = m * p1.x + b;

            Ponto inter = new Ponto(p1.x, y);

            return (inter.y >= Math.min(p1.y, p2.y) && inter.y <= Math.max(p1.y, p2.y) && inter.x >= Math.min(s.getP1().x, s.getP2().x) && inter.x <= Math.max(s.getP1().x, s.getP2().x));
        } else {
            double m1 = (p2.y - p1.y) / (p2.x - p1.x);
            double m2 = (s.getP2().y - s.getP1().y) / (s.getP2().x - s.getP1().x);
            if (m1 == m2 && p1.x != s.p1.x) {
                return false;
            }
            double b1 = p1.y - m1 * p1.x;
            double b2 = s.getP1().y - m2 * s.getP1().x;

            double x = (b2 - b1) / (m1 - m2);
            double y = m1 * x + b1;

            Ponto inter = new Ponto(x, y);

            return (inter.x <= Math.max(p1.x, p2.x) && inter.x >= Math.min(p1.x, p2.x)
                    && inter.y <= Math.max(p1.y, p2.y) && inter.y >= Math.min(p1.y, p2.y)
                    && inter.x <= Math.max(s.getP1().x, s.getP2().x) && inter.x >= Math.min(s.getP1().x, s.getP2().x)
                    && inter.y <= Math.max(s.getP1().y, s.getP2().y) && inter.y >= Math.min(s.getP1().y, s.getP2().y));
        }
    }


}

