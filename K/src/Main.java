import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] traj1 = s1.split(" ");
        String[] traj2 = s2.split(" ");
        ArrayList<Ponto> pontos1 = new ArrayList<>();
        ArrayList<Ponto> pontos2 = new ArrayList<>();
        for(int i = 0; i < traj1.length-1; i++){
            Ponto p1 = new Ponto(Integer.parseInt(traj1[i]), Integer.parseInt(traj1[i+1]));
            pontos1.add(p1);
            i++;
        }
        for(int i = 0; i < traj2.length-1; i++){
            Ponto p1 = new Ponto(Integer.parseInt(traj2[i]), Integer.parseInt(traj2[i+1]));
            pontos2.add(p1);
            i++;
        }
        Trajetoria trajetoria1 = new Trajetoria(pontos1);
        Trajetoria trajetoria2 = new Trajetoria(pontos2);
        ArrayList<Trajetoria> trajetorias = new ArrayList<>();
        trajetorias.add(trajetoria1);
        trajetorias.add(trajetoria2);
        Populacao pop = new Populacao(trajetorias);
        pop.cortada(pop);
        System.out.println(pop);
    }
}