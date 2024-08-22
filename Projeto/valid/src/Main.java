import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int battery = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            Ponto pr = new Ponto(x, y);
            Robot robot = new Robot(pr, battery);
        int Npontos = sc.nextInt();
        ArrayList<Ponto> pontos = new ArrayList<>();
        for( int i = 0; i < Npontos; i++){
            int p1x = sc.nextInt();
            int p1y = sc.nextInt();
            Ponto p1 = new Ponto(p1x, p1y);
            pontos.add(p1);
        }
        robot.setPontos(pontos);
        Gestor gestor = new Gestor(robot);
        double result = robot.batteryNeeded();
        double batterysub = robot.battery() - result;
        gestor.ver();
        System.out.println(String.format("%.2f", batterysub));
    }
}
