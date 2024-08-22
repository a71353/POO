import java.lang.reflect.*;
import java.util.*;
public class Cliente {

    public static String capital(String s) {
        String res = s.toLowerCase();
        Character initial = Character.toUpperCase(res.charAt(0));
        StringBuilder sb = new StringBuilder(res);
        sb.setCharAt(0, initial);
        final String answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Random randomGenerator = new Random(0);
        Populacao pop = new Populacao();
        double pm = in.nextDouble();
        double pa=in.nextDouble();
        double pr = in.nextDouble();
        int x = in.nextInt();
        int y =in.nextInt();
        Ponto ponto = new Ponto(x,y);
        int x2= in.nextInt();
        int y2=in.nextInt();
        Ponto ponto2=new Ponto(x2,y2);
        int n=in.nextInt(); // numero de populacao
        while(n!=0){
            int f=in.nextInt(); // numero de pontos da trajetoria
            Caminho a = new Caminho(randomGenerator,f,ponto,ponto2);
            pop.addCaminhoList(a);
            n--;
        }


        ArrayList<FiguraGeometrica> figs = new ArrayList<FiguraGeometrica>();
        Constructor<?> constructor;
        Class<?> cl;
        FiguraGeometrica f;
        String s;
        String[] aos;

        in.nextLine();
        while (in.hasNextLine()) {
            s = in.nextLine();
            if (s.isEmpty())
                break;
            aos = s.split(" ");
            try {
                cl = Class.forName(capital(aos[0]));
                constructor = cl.getConstructor(String.class);
                f = (FiguraGeometrica) constructor.newInstance(s);
                figs.add(f);
            } catch (Exception e) {
                System.out.println("Tipo de obstaculo desconhecido");
                System.exit(0);
            }
        }
        in.close();


        Populacao pop2= new Populacao();

        pop2=pop.torneio(randomGenerator,figs);
        pop2.recombinacaopopulacao2(randomGenerator);
        pop2.mutacaopopulacao(pm,randomGenerator);
        pop2.adicaopopulacao(pa,randomGenerator);
        pop2.remocaopopulacao(pr,randomGenerator);

        System.out.println("0: "+String.format("%.2f",pop2.avaliacao_maxima(figs))+" "+String.format("%.2f",pop2.avaliacao_media(figs))+" "+String.format("%.2f",pop2.avaliacao_minima(figs))+" "+String.format("%.2f",pop2.menor_trajetoria_conta_minima(figs))+" "+pop2.contas_minima(figs));

    }


}