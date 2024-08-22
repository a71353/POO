/**
 * @author 71353 Gonçalo Figueiredo
 */

import java.util.*;

public class Populacao {

    Generator generator = new Generator(0);
    private ArrayList<Trajetoria> trajetorias;

    /**
     * @param n trajetorias
     * @param traj trajetorias
     * @param inicial ponto inicial
     * @param fim ponto final
     */
    public Populacao (int n, int [] traj, Ponto inicial, Ponto fim) {
        trajetorias = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Ponto> pontos = new ArrayList<>();
            for (int j = 0; j < traj[i]; j++) {
                int x = generator.Nextint(100);
                int y = generator.Nextint(100);
                Ponto p1 = new Ponto(x, y);
                pontos.add(p1);
            }
            pontos.add(0,inicial);
            pontos.add(fim);
            trajetorias.add(new Trajetoria(pontos));
        }
    }

    /**
     * @return arraylist de trajetorias
     */
    public ArrayList<Trajetoria> trajetorias(){
        return trajetorias;
    }

    /**
     * @param fig lista de figuras geometricas
     */
    public void orden(List<FiguraGeometrica> fig){
        ArrayList<Trajetoria> trajord = new ArrayList<>();
        for(int i = 0; i < trajetorias.size(); i++){
            Trajetoria traj1 = trajetorias.get(generator.Nextint(trajetorias.size()));
            Trajetoria traj2 = trajetorias.get(generator.Nextint(trajetorias.size()));
            if(traj1.avaluation(fig) >= traj2.avaluation(fig)){
                trajord.add(traj1);
            }
            else {
                trajord.add(traj2);
            }
        }
        System.out.println(trajetorias.toString());
        this.trajetorias = trajord;
    }

    /**
     *
     * @return retorna o "\n"
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trajetorias.size(); i++) {
            sb.append(trajetorias.get(i).toString());
            if (i != trajetorias.size() - 1) {
                sb.append("\n"); // Adiciona uma quebra de linha após cada trajetória, exceto a última
            }
        }
        return sb.toString();
    }
}
