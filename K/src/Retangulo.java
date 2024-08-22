import java.util.ArrayList;

public class Retangulo extends FiguraGeometrica{
    private Ponto p1;
    private Ponto p2;
    private Ponto p3;
    private Ponto p4;
    private SegReta lado1;
    private SegReta lado2;
    private SegReta lado3;
    private SegReta lado4;

    /**
     *
     * @param string retangulo e pontos
     */
    public Retangulo(String string) {
        super(string);
        String[] ret = string.split(" ");
        this.p1 = new Ponto(Integer.parseInt(ret[1]), Integer.parseInt(ret[2]));
        this.p2 = new Ponto(Integer.parseInt(ret[3]), Integer.parseInt(ret[4]));
        this.p3 = new Ponto(Integer.parseInt(ret[5]), Integer.parseInt(ret[6]));
        this.p4 = new Ponto(Integer.parseInt(ret[7]), Integer.parseInt(ret[8]));
        this.lado1 = new SegReta(p1, p2);
        this.lado2 = new SegReta(p2, p3);
        this.lado3 = new SegReta(p3, p4);
        this.lado4 = new SegReta(p4, p1);
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
     * @return ponto4
     */
    public Ponto getP4() {
        return p4;
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
     * @return lado4
     */
    public SegReta getLado4() {
        return lado4;
    }

    /**
     *
     * @param trajetoria
     * @return true se intersetar a trajetoria
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
                if (seg.get(i).getP1().x == seg.get(i).getP2().x) {
                    if (((seg.get(i).getP1().x >= this.getP1().x && seg.get(i).getP1().x <= seg.get(i).getP2().x) && (seg.get(i).getP1().y <= this.getP1().y && seg.get(i).getP2().y >= this.getP1().y)) || ((seg.get(i).getP1().x >= this.getP4().x && seg.get(i).getP1().x <= this.getP3().x) && (seg.get(i).getP1().y <= this.getP4().y && seg.get(i).getP2().y >= this.getP4().y))) {
                        return true;
                    }
                    break;
                }
                if (this.getLado1().intercetarect(seg.get(i))) {
                    return true;
                }
                if (this.getLado2().intercetarect(seg.get(i))) {
                    return true;
                }
                if (this.getLado3().intercetarect(seg.get(i))) {
                    return true;
                }
                if (this.getLado4().intercetarect(seg.get(i))) {
                    return true;
                }
        }
        return false;
    }

    /**
     * verifica se é um retangulo valido
     */
    @Override
    public void verifica() {
        if(p1.dist(p3) != p2.dist(p4) && p1.dist(p3) != 0){
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
    }
}