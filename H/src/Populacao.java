import java.util.ArrayList;
import java.util.Random;

public class Populacao {
    private ArrayList<Trajetoria> trajetorias;
    public Populacao (int n, int [] traj) {
        trajetorias = new ArrayList<>();
        Random generator = new Random(0);
        for (int i = 0; i < n; i++) {
            ArrayList<Ponto> pontos = new ArrayList<>();
            for (int j = 0; j < traj[i]; j++) {
                int x = generator.nextInt(100);
                int y = generator.nextInt(100);
                Ponto p1 = new Ponto(x, y);
                pontos.add(p1);
            }
            trajetorias.add(new Trajetoria(pontos));
        }
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
