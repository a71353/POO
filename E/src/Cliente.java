import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Ponto> pontos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            pontos.add(new Ponto(x, y));
        }

        List<SegReta> seg = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            seg.add(new SegReta(pontos.get(i), pontos.get(i + 1)));
        }

        int m = sc.nextInt();

        List<Retangulo> retangulos = new ArrayList<>(m);

        for (int j = 0; j < m; j++) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double x3 = sc.nextDouble();
            double y3 = sc.nextDouble();
            double x4 = sc.nextDouble();
            double y4 = sc.nextDouble();
            Ponto p1 = new Ponto(x1, y1);
            Ponto p2 = new Ponto(x2, y2);
            Ponto p3 = new Ponto(x3, y3);
            Ponto p4 = new Ponto(x4, y4);
            Retangulo retangulo = new Retangulo(p1, p2, p3, p4);
            pontos.add(p1);
            pontos.add(p2);
            pontos.add(p3);
            pontos.add(p4);
            retangulos.add(retangulo);
        }

        for (Ponto ponto : pontos) {
            if (!ponto.verify()) {
                System.out.println("Ponto:vi");
                System.exit(0);
            }
        }

        for (Retangulo retangulo : retangulos) {
            if (!retangulo.verrect() || retangulo.getP1().dist(retangulo.getP3()) == 0) {
                System.out.println("Retangulo:vi");
                System.exit(0);
            }
        }

        for (SegReta segReta : seg) {
            if (!segReta.verseg()) {
                System.out.println("Segmento:vi");
                System.exit(0);
            }
        }

        Trajetoria trajetoria = new Trajetoria(seg);

        for (int i = 0; i < seg.size(); i++) {
            if (!trajetoria.vertraj()) {
                System.out.println("Trajetoria:vi");
                System.exit(0);
            }
        }

        int count = trajetoria.intersections(retangulos);
        System.out.println(count);
    }
}