//@author 71353 Gonçalo Figueiredo
//@version 1 21/02/2022
//@inv a distância entre as 2 diagonais de retangulo têm que ser iguais e diferente de 0
public class Retangulo {
    private Ponto p1;
    private Ponto p2;
    private Ponto p3;
    private Ponto p4;
//@param os 4 pontos do rentagulo
    public Retangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.p4 = p4;
        }


    public boolean verrect() {
            return p1.dist(p3) == p2.dist(p4) && p1.dist(p3) != 0;
        }//@return retorna true se se verificar a condição

}