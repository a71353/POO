public class Retangulo {
    private Ponto p1;
    private Ponto p2;
    private Ponto p3;
    private Ponto p4;
    private SegReta lado1;
    private SegReta lado2;
    private SegReta lado3;
    private SegReta lado4;

    public Retangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.lado1 = new SegReta(p1, p2);
        this.lado2 = new SegReta(p2, p3);
        this.lado3 = new SegReta(p3, p4);
        this.lado4 = new SegReta(p4, p1);
    }

    public boolean verrect() {
        return p1.dist(p3) == p2.dist(p4);
    }

    public Ponto getP1() {
        return p1;
    }

    public Ponto getP2() {
        return p2;
    }

    public Ponto getP3() {
        return p3;
    }

    public Ponto getP4() {
        return p4;
    }

    public SegReta getLado1() {
        return lado1;
    }

    public SegReta getLado2() {
        return lado2;
    }

    public SegReta getLado3() {
        return lado3;
    }

    public SegReta getLado4() {
        return lado4;
    }
}