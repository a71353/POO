/**
 * Esta classe trabalha com triangulos.
 * Esta classe é uma subclasse de poligonos
 */

import java.util.ArrayList;

public class Triangulo extends Poligono {

    /**
     * Este método serve para ver se os pontos dados ,são realmente um triangulo
     */
    public void trianguloVF(){
        Reta reta1= new Reta(pontos.get(0),pontos.get(1));
        Reta reta2= new Reta(pontos.get(1),pontos.get(2));
        Reta reta3= new Reta(pontos.get(2),pontos.get(0));
        if((reta1.m()==reta2.m() && reta1.b()==reta2.b()) &&(reta1.m()==reta3.m() && reta1.b()==reta3.b())){
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
    }

    /**
     * Este método é um construtor de triangulos, cria também segmentos com os pontos dados
     * @param ponto1 é o primeiro ponto necessario
     * @param ponto2 é segundo ponto necessário
     * @param ponto3 é o terceiro ponto necessário
     */
    public Triangulo(Ponto ponto1,Ponto ponto2,Ponto ponto3){
        this.pontos.add(ponto1);
        this.pontos.add(ponto2);
        this.pontos.add(ponto3);
        trianguloVF();
        SegmentoReta seg1= new SegmentoReta(pontos.get(0),pontos.get(1));
        SegmentoReta seg2= new SegmentoReta(pontos.get(1),pontos.get(2));
        SegmentoReta seg3 = new SegmentoReta(pontos.get(2),pontos.get(0));
        this.segmentos.add(seg1);
        this.segmentos.add(seg2);
        this.segmentos.add(seg3);
    }

    /**
     * Este método, é um construtor do triangulo só que só dá uma string como parametro
     * @param palavra é a string dada
     */
    public Triangulo(String palavra){
        String frase[] = palavra.split(" ");
        this.pontos.add(new Ponto(Double.parseDouble(frase[1]),Double.parseDouble(frase[2])));
        this.pontos.add(new Ponto(Double.parseDouble(frase[3]),Double.parseDouble(frase[4])));
        this.pontos.add(new Ponto(Double.parseDouble(frase[5]),Double.parseDouble(frase[6])));
        trianguloVF();
        this.segmentos.add(new SegmentoReta(pontos.get(0),pontos.get(1)));
        this.segmentos.add(new SegmentoReta(pontos.get(1),pontos.get(2)));
        this.segmentos.add(new SegmentoReta(pontos.get(2),pontos.get(0)));
    }
}
