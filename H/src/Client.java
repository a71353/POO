import java.util.*;

/**
 * @author 71353 Gonçalo Figueiredo
 * version 1 08/03/2022
 * 
 */
public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] trajetorias = new int[n];
        for(int i = 0; i< n; i++) {
            trajetorias[i] = sc.nextInt();
        }
        sc.close();
        Populacao populacao = new Populacao(n, trajetorias);
        System.out.print(populacao + "\n");
    }
}