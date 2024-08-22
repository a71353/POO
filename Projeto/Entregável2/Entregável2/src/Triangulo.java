import java.awt.*;
import java.util.ArrayList;

public class Triangulo extends FiguraGeometrica{

    private Ponto p1;
    private Ponto p2;
    private Ponto p3;

    private SegReta lado1;
    private SegReta lado2;
    private SegReta lado3;

    /**
     *
     * @param s string  triangulo com pontos
     */
    public Triangulo(String s) {
        super(s);
        String[] triangulo = s.split(" ");
        this.p1 = new Ponto(Integer.parseInt(triangulo[1]), Integer.parseInt(triangulo[2]));
        this.p2 = new Ponto(Integer.parseInt(triangulo[3]), Integer.parseInt(triangulo[4]));
        this.p3 = new Ponto(Integer.parseInt(triangulo[5]), Integer.parseInt(triangulo[6]));
        this.lado1 = new SegReta(p1, p2);
        this.lado2 = new SegReta(p2, p3);
        this.lado3 = new SegReta(p3, p1);
    }


    /**
     *
     * @return ponto1
     */
    public Ponto getP1() {
        return p1;
    }
    /**
     *
     * @return ponto2
     */
    public Ponto getP2() {
        return p2;
    }
    /**
     *
     * @return ponto3
     */
    public Ponto getP3() {
        return p3;
    }

    /**
     *
     * @return lado1
     */
    public SegReta getLado1() {
        return lado1;
    }
    /**
     *
     * @return lado2
     */
    public SegReta getLado2() {
        return lado2;
    }
    /**
     *
     * @return lado3
     */
    public SegReta getLado3() {
        return lado3;
    }

    /**
     *
     * @param trajetoria
     * @return true se intersetar com a trajetoria
     */
    @Override
    public boolean intercecao(Trajetoria trajetoria) {
        ArrayList<Ponto> pontos = trajetoria.getpontos();
        ArrayList<SegReta> seg = new ArrayList<>(pontos.size()-1);
        for(int i = 0; i < pontos.size()-1; i++){
            SegReta segReta = new SegReta(pontos.get(i), pontos.get(i+1));
            seg.add(segReta);
        }
        for (int i = 0; i < seg.size(); i++) {
            if (this.getLado1().intercetarect(seg.get(i))) {
                return true;
            }
            if (this.getLado2().intercetarect(seg.get(i))) {
                return true;
            }
            if (this.getLado3().intercetarect(seg.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void verifica() {
        if(p1.dist(p2) + p2.dist(p3) <= p3.dist(p1) || p1.dist(p2) + p1.dist(p3) <= p2.dist(p3) || p2.dist(p3) + p1.dist(p3) <= p1.dist(p2)){
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
        if(p1.x == p2.x && p1.x == p3.x || p1.y == p2.y && p1.y == p3.y || p1.x == p1.y && p2.x == p2.y && p3.x == p3.y){
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
    }

    @Override
    public void desenha(Graphics g) {
        int[] x = {(int) getP1().x, (int) getP2().x, (int) getP3().x};
        int[] y = {(int) getP1().y, (int) getP2().y, (int) getP3().y};
        g.drawPolygon(x,y,3);
        g.fillPolygon(x,y,3);
    }
}

