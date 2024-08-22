/**@author 71353 Gonçalo Figueiredo
@version 1 21/02/2022
*/
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ponto p1 = new Ponto(sc.nextDouble(), sc.nextDouble());
        Ponto p2 = new Ponto(sc.nextDouble(), sc.nextDouble());
        Ponto p3 = new Ponto(sc.nextDouble(), sc.nextDouble());
        Ponto p4 = new Ponto(sc.nextDouble(), sc.nextDouble());
        Ponto p5 = new Ponto(sc.nextDouble(), sc.nextDouble());
        Ponto p6 = new Ponto(sc.nextDouble(), sc.nextDouble());

        Retangulo r1 = new Retangulo(p1, p2, p3, p4);
        SegReta s1 = new SegReta(p5, p6);
        SegReta s2 = new SegReta(p1, p2);
        SegReta s3 = new SegReta(p2, p3);
        SegReta s4 = new SegReta(p3, p4);
        SegReta s5 = new SegReta(p4, p1);


//verifica se os pontos estão todos no primeiro quadrante
        if (!p1.verify() || !p2.verify() || !p3.verify() || !p4.verify() || !p5.verify() || !p6.verify()) {
            System.out.println("Ponto:vi");
            System.exit(0);
        }

        //verifica se os 4 pontos do r1 formam um retangulo
        if(!r1.verrect()){
            System.out.println("Retangulo:vi");
            System.exit(0);
        }

        //verifica se os pontos do segmento de reta s1 formam um segmento de reta,se os 2 pontos são diferentes
        if(!s1.verseg()){
            System.out.println("Segmento:vi");
            System.exit(0);
        }

        //se o segmento de reta for vertical
        if(p5.x == p6.x){
            //tem que estar entre o x dos limites do retangulo e entre o y dos limites do retangulo
            if(((p5.x >= p1.x && p5.x <= p2.x) && (p5.y <= p1.y && p6.y >= p1.y)) || ((p5.x >= p4.x && p5.x <= p3.x) && (p5.y <= p4.y && p6.y >= p4.y))){
                System.out.println("Fail");
                System.exit(0);
            }
        }//se não esxiste interseção usando a função na classe segreta print ok
        if(!s2.interceta(s1) && !s1.intercetavert(s3) && !s4.interceta(s1) && !s1.intercetavert(s5)){
            System.out.println("OK");
            System.exit(0);
        }
        else{
            System.out.println("Fail");
            System.exit(0);
        }

    }
}