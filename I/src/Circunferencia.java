/**
 * @author 71353 Gonçalo Figueiredo
 * @inv o raio nao pode ser menor que 0
 */

import java.util.ArrayList;

public class Circunferencia extends FiguraGeometrica{

    private Ponto p1;

    int r;

    /**
     *
     * @param s string circunferencia e com pontos
     */
    public Circunferencia(String s) {
        super(s);
        String[] circ = s.split(" ");
        this.p1 = new Ponto(Integer.parseInt(circ[1]), Integer.parseInt(circ[2]));
        this.r = Integer.parseInt(circ[3]);
    }

    /**
     * @param seg segmento que vai ser verificado na interseção
     * @return retorna true se intersetar com a circunferencia
     */
    public boolean isSegmentIntersectCircle(SegReta seg) {
        if (seg.getP1().x == seg.getP2().x) {
            double dx = seg.getP1().x - this.p1.x;
            if (Math.abs(dx) > this.r) {
                return false;
            } else {
                double dy = Math.sqrt(this.r * this.r - dx * dx);
                double y1 = this.p1.y - dy;
                double y2 = this.p1.y + dy;
                return (y1 >= seg.getP1().y && y1 <= seg.getP2().y) || (y2 >= seg.getP1().y && y2 <= seg.getP2().y);
            }
        } else {
            double dx = seg.getP2().x - seg.getP1().x;
            double dy = seg.getP2().y - seg.getP1().y;
            double a = dx * dx + dy * dy;
            double b = 2 * (dx * (seg.getP1().x - this.p1.x) + dy * (seg.getP1().y - this.p1.y));
            double c = this.p1.x * this.p1.x + this.p1.y* this.p1.y + seg.getP1().x * seg.getP1().x + seg.getP1().y * seg.getP1().y - 2 * (this.p1.x * seg.getP1().x + this.p1.y * seg.getP1().y) - this.r * this.r;
            double disc = b * b - 4 * a * c;
            if (disc < 0) {
                return false;
            } else {
                disc = Math.sqrt(disc);
                double t1 = (-b - disc) / (2 * a);
                double t2 = (-b + disc) / (2 * a);
                if ((t1 >= 0 && t1 <= 1) || (t2 >= 0 && t2 <= 1)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * @param trajetoria
     * @return retorna true se a trajetoria intersetar com a circunferencia
     */
    @Override
    public boolean intercecao(Trajetoria trajetoria) {
        ArrayList<SegReta> seg = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < trajetoria.getpontos().size() - 1; i++) {
            Ponto ponto5 = trajetoria.getpontos().get(i);
            Ponto ponto6 = trajetoria.getpontos().get(i + 1);
            SegReta segmento = new SegReta(ponto5, ponto6);
            if (this.isSegmentIntersectCircle(segmento)){
                count++;
            }
            seg.add(segmento);
        }
        if(count != 0){
            return true;
        }
        return false;
    }

    @Override
    public void verifica() {
        if(r < 0){
            System.out.println("Circunferencia:vi");
            System.exit(0);
        }
    }
}

