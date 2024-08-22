//@author 71353 Gonçalo Figueiredo
//@version 1 21/02/2022
//@see https://stackoverflow.com/questions/31506740/java-find-intersection-of-two-lines
//@inv os 2 pontos do segmento de reta têm que ser diferentes
public class SegReta {

    private Ponto p1;

    private Ponto p2;

    //@param pontos do segmento de reta
    public SegReta(Ponto p1, Ponto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    //@return retorna true se os pontos forem diferentes
    public boolean verseg(){
        return p1.x != p2.x || p1.y != p2.y;
    }

    public boolean interceta(SegReta s) {

        double m1 = (p2.y - p1.y) / (p2.x - p1.x);
        double m2 = (s.p2.y - s.p1.y) / (s.p2.x - s.p1.x);

        double b1 = p1.y - m1 * p1.x;
        double b2 = s.p1.y - m2 * s.p1.x;

        double x = (b2 - b1) / (m1 - m2);
        double y = m1 * x + b1;

        Ponto inter = new Ponto(x, y);

        return ((inter.x <= Math.max(p1.x, p2.x) && inter.x >= Math.min(p1.x, p2.x))
                && (inter.y <= Math.max(p1.y, p2.y) && inter.y >= Math.min(p1.y, p2.y))
                && (inter.x <= Math.max(s.p1.x, s.p2.x) && inter.x >= Math.min(s.p1.x, s.p2.x))
                && (inter.y <= Math.max(s.p1.y, s.p2.y) && inter.y >= Math.min(s.p1.y, s.p2.y)));
    }//@return retorna true caso o ponto de interseção esteja dentro dos limites


    public boolean intercetavert(SegReta s){
        double m = (p2.y - p1.y)/(p2.x - p1.x);

        double b = p1.y - m * p1.x;

        double y = m * s.p1.x + b;

        Ponto inter = new Ponto(s.p1.x, y);

        return (inter.y >= s.p1.y && inter.y <= s.p2.y);
    }//@return retorna true caso o ponto de interseção esteja dentro dos limites
}
