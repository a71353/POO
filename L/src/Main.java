import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] trajetorias = new int[n];
        for(int i = 0; i < n; i++) {
            trajetorias[i] = sc.nextInt();
        }
        Populacao pop = new Populacao(n, trajetorias);
        double p = sc.nextDouble();
        pop.mutation(p);
        System.out.println(pop);
    }
}