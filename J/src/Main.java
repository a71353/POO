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
        int xi = sc.nextInt();
        int yi = sc.nextInt();
        int xf = sc.nextInt();
        int yf = sc.nextInt();
        int n = sc.nextInt();
        Ponto pi = new Ponto(xi, yi);
        Ponto pf = new Ponto(xf, yf);
        int [] trajetorias = new int[n];
        for(int i = 0; i < n; i++) {
            trajetorias[i] = sc.nextInt();
        }
        Populacao populacao = new Populacao(n, trajetorias, pi, pf);
        sc.nextLine();
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
            }
        }
        populacao.orden(obstaculos);
        System.out.println(populacao);
        sc.close();
    }
}