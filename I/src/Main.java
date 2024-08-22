import java.lang.reflect.*;
import java.util.*;
public class Main {
    public static String capital(String s) {
        String res = s.toLowerCase();
        Character initial = Character.toUpperCase(res.charAt(0));
        StringBuilder sb = new StringBuilder(res);
        sb.setCharAt(0, initial);
        final String answer = sb.toString();
        return answer;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner (System.in);
        List<FiguraGeometrica> obstaculos = new ArrayList<>();
        ArrayList<Ponto> pontos = new ArrayList<>();
        String linhaTrajetoria = sc.nextLine();
        String[] coordenadas = linhaTrajetoria.split(" ");
        for (int i = 0; i < coordenadas.length; i += 2) {
            int x = Integer.parseInt(coordenadas[i]);
            int y = Integer.parseInt(coordenadas[i + 1]);
            Ponto ponto = new Ponto(x, y);
            pontos.add(ponto);
        }
        Trajetoria traj = new Trajetoria(pontos);
        FiguraGeometrica f;
        String s;
        String [] aos;
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            aos = s.split(" ");
            try {
                Class<?> cl = Class.forName(capital(aos[0]));
                Constructor<?> constructor = cl.getConstructor(new Class<?>[] { String.class });
                f = (FiguraGeometrica) constructor.newInstance(s);
                f.verifica();
                obstaculos.add(f);
            }
            catch (Exception e) {
                System.out.println("Tipo de obstaculo desconhecido");
                System.exit(0);
            }
        }
        System.out.println(String.format("%.2f", traj.avaluation(obstaculos)));
        sc.close();
    }
}