import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Path path = new Path();
        for(int i = 0; i < n; i++){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            Ponto p = new Ponto(x, y);
            path.addPontos(p);
        }
        double total = path.caminhototal();
        System.out.println(String.format("%.2f", total));
    }
}