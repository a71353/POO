import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        Ponto ponto1 = new Ponto(x, y);
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        Ponto ponto2 = new Ponto(x2, y2);
        int dist = (int) ponto1.dist(ponto2);
        System.out.println(dist);
    }
}