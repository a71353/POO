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
        int g = in.nextInt(); // é o numero de gerações que se vai fazer
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

        int result=0;
        Populacao pop2= new Populacao();
        while(g!=0){
            //System.out.println("Inicio");
            //System.out.println(pop.toString());
            pop2=pop.torneio(randomGenerator,figs);
            //System.out.println("Torneio");
            //System.out.println(pop2.toString());
            pop2.recombinacaopopulacao2(randomGenerator);
            //System.out.println("Mix");
            //System.out.println(pop2.toString());
            pop2.mutacaopopulacao(pm,randomGenerator);
            //System.out.println("Mutacao");
            //System.out.println(pop2.toString());
            pop2.adicaopopulacao(pa,randomGenerator);
            //System.out.println("Adicao");
            //System.out.println(pop2.toString());
            pop2.remocaopopulacao(pr,randomGenerator);
            //System.out.println("Final");
            //System.out.println(pop2.toString());

            System.out.println(result+": "+String.format("%.2f",pop2.avaliacao_maxima(figs))+" "+String.format("%.2f",pop2.avaliacao_media(figs))+" "+String.format("%.2f",pop2.avaliacao_minima(figs))+" "+String.format("%.2f",pop2.menor_trajetoria_conta_minima(figs))+" "+pop2.contas_minima(figs));

            /*
            for(int i=0;i<pop2.retornaCaminhos().size();i++){
                System.out.println("primeiro\n\n\n");
                System.out.println(pop2.retornaCaminhos().get(i).distanciaCaminho());
                System.out.println(pop2.retornaCaminhos().get(i).contas(figs));
            }


             */




            result++;
            pop=pop2;
            g--;
        }
    }
}