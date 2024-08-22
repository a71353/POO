import java.util.ArrayList;

public class Retangulo extends Poligono{
    /**
     * @autor Goncalo Figueiredo
     * @version 1
     * */

private Ponto pontoMedio;

    /**
     * Este método, vai verificar se os Pontos que nós damos ao criar um retangulo, representa realmente um retangulo
     * ou seja vamos comparar a distancia entre o ponto 1 ao ponto médio, e ela tem que ser igual á distancia  entre o
     * ponto médio e o ponto3.E o mesmo tem que acontecer para o ponto2 e 4.
     * @return retorna um booleano(true, se os pontos dados formam um retangulo e falso caso contrário).
     */
    public void retanguloVF() { //vai ver se Ã© um retangulo
        if(pontoMedio.dist(pontos.get(0)) == pontoMedio.dist(pontos.get(2)) && pontoMedio.dist(pontos.get(1)) == pontoMedio.dist(pontos.get(3)) && pontoMedio.dist(pontos.get(0)) !=0 && pontoMedio.dist(pontos.get(1))!=0)
            return;
        System.out.println("Retangulo:vi");
        System.exit(1);

    }

    /**
     * Este método é o construtor, da classe retangulo.Um retangulo necessita de 4 pontos.E cria também segmentos
     * de reta , com base nos pontos dado.
     * @param ponto1 é o ponto inical para a criação de cada retangulo.
     * @param ponto2 é o segundo ponto para a criação de cada retangulo.
     * @param ponto3 é o terceiro ponto para a criação de cada retangulo.
     * @param ponto4 é o quarto ponto para a criação de cada retangulo.
     * @inv Retangulo:vi caso, os pontos dados não formem um retangulo, vai
     * informar que ocorreu uma invariante,e terminamos o programa.
     */

    public Retangulo(Ponto ponto1,Ponto ponto2,Ponto ponto3,Ponto ponto4){  //NOTA A DISTANCIA TEM QUE SER DIFERENTE DE 0
        this.pontos.add(ponto1);
        this.pontos.add(ponto2);
        this.pontos.add(ponto3);
        this.pontos.add(ponto4);
        this.pontoMedio= new Ponto((ponto1.getX()+ponto2.getX()+ponto3.getX()+ponto4.getX())/4,(ponto1.getY()+ponto2.getY()+ponto3.getY()+ponto4.getY())/4);
        retanguloVF();
        this.segmentos.add(new SegmentoReta(ponto1,ponto2));
        this.segmentos.add(new SegmentoReta(ponto2,ponto3));
        this.segmentos.add(new SegmentoReta(ponto3,ponto4));
        this.segmentos.add(new SegmentoReta(ponto4,ponto1));
    }

    /**
     * Este método é um construtor de ratangulos em que aceita apenas uma string como argumento
     * @param palavra é a string usada
     */
    public Retangulo(String palavra){
        String frase[] = palavra.split(" ");
        this.pontos.add(new Ponto(Double.parseDouble(frase[1]),Double.parseDouble(frase[2])));
        this.pontos.add(new Ponto(Double.parseDouble(frase[3]),Double.parseDouble(frase[4])));
        this.pontos.add(new Ponto(Double.parseDouble(frase[5]),Double.parseDouble(frase[6])));
        this.pontos.add(new Ponto(Double.parseDouble(frase[7]),Double.parseDouble(frase[8])));
        this.pontoMedio= new Ponto((pontos.get(0).getX()+pontos.get(1).getX()+pontos.get(2).getX()+pontos.get(3).getX())/4,(pontos.get(0).getY()+pontos.get(1).getY()+pontos.get(2).getY()+pontos.get(3).getY())/4);
        retanguloVF();
        this.segmentos.add(new SegmentoReta(getPonto1(),getPonto2()));
        this.segmentos.add(new SegmentoReta(getPonto2(),getPonto3()));
        this.segmentos.add(new SegmentoReta(getPonto3(),getPonto4()));
        this.segmentos.add(new SegmentoReta(getPonto4(),getPonto1()));
    }


    /**
     * Este método retorna o ponto1
     * @return retorna o ponto1
     */
    public Ponto getPonto1() {
        return pontos.get(0);
    }

    /**
     * Este método retorna o ponto2
     * @return retorna o ponto2
     */
    public Ponto getPonto2() {
        return pontos.get(1);
    }
    /**
     * Este método retorna o ponto3
     * @return retorna o ponto3
     */

    public Ponto getPonto3() {
        return pontos.get(2);
    }

    /**
     * Este método retorna o ponto4
     * @return retorna o ponto4
     */
    public Ponto getPonto4() {
        return pontos.get(3);
    }

}