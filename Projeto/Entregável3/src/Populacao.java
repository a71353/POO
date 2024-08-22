import java.util.*;

public class Populacao {

    private ArrayList<Trajetoria> trajetorias;

    /**
     *
     * @param trajetorias1
     */
    public Populacao(ArrayList<Trajetoria> trajetorias1){
        this.trajetorias = trajetorias1;
    }


    /**
     * @param n de pontos na traj
     * @param traj com n pontos
     * @param inicial ponto inicial
     * @param fim ponto final
     */
    public Populacao (Random generator, int n, int [] traj, Ponto inicial, Ponto fim) {
        trajetorias = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Ponto> pontos = new ArrayList<>();
            for (int j = 0; j < traj[i]; j++) {
                double x = generator.nextDouble(inicial.x / 1.5, inicial.x * 1.5);
                double y = generator.nextDouble(fim.y / 1.5, fim.y * 1.5);
                if(x < 0){
                    x = 1;
                }
                if(y < 0){
                    y = 1;
                }
                if(x > 1000){
                    x = 1000;
                }
                if(y > 1000){
                    y = 1000;
                }
                Ponto p1 = new Ponto(x, y);
                pontos.add(p1);
            }
            pontos.add(0,inicial);
            pontos.add(fim);
            trajetorias.add(new Trajetoria(pontos));
        }
    }

    /**
     *
     * @param n n pontos
     * @param traj com n pontos
     */
    public Populacao (Random generator, int n, int [] traj) {
        trajetorias = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Ponto> pontos = new ArrayList<>();
            for (int j = 0; j < traj[i]; j++) {
                int x = generator.nextInt(1000);
                int y = generator.nextInt(1000);
                Ponto p1 = new Ponto(x, y);
                pontos.add(p1);
            }
            trajetorias.add(new Trajetoria(pontos));
        }
    }

    /**
     *
     * @return´arraylist de trajetorias
     */
    public ArrayList<Trajetoria> trajetorias(){
        return trajetorias;
    }

    /**
     * ordena as trajetorias escolhendo aleatoriamente
     * @param fig
     */
    public void orden(Random generator, List<FiguraGeometrica> fig){
        ArrayList<Trajetoria> trajord = new ArrayList<>();
        for(int i = 0; i < trajetorias.size(); i++){
            Trajetoria traj1 = trajetorias.get(generator.nextInt(trajetorias.size()));
            Trajetoria traj2 = trajetorias.get(generator.nextInt(trajetorias.size()));
            if(traj1.avaluation(fig) >= traj2.avaluation(fig)){
                trajord.add(traj1);
            }
            else {
                trajord.add(traj2);
            }
        }
        this.trajetorias = trajord;
    }

    /**
     * corta as trajetorias
     * @param pop
     */
    public void cortada(Random generator, Populacao pop){
        ArrayList<Trajetoria> traj = new ArrayList<>();
        Trajetoria trajetoria1 = pop.trajetorias.get(0);
        Trajetoria trajetoria2 = pop.trajetorias.get(1);
        int cut1 = generator.nextInt(trajetoria1.getpontos().size() - 1) + 1;
        int cut2 = generator.nextInt(trajetoria2.getpontos().size() - 1) + 1;
        ArrayList<Ponto> pontos1 = new ArrayList<>();
        ArrayList<Ponto> pontos2 = new ArrayList<>();
        for(int i = 0; i < cut1; i++){
            pontos1.add(trajetoria1.getpontos().get(i));
        }
        for(int i = 0; i < cut2; i++){
            pontos2.add(trajetoria2.getpontos().get(i));
        }
        for(int i = cut2; i < trajetoria2.getpontos().size(); i++){
            pontos1.add(trajetoria2.getpontos().get(i));
        }
        for(int i = cut1; i < trajetoria1.getpontos().size(); i++){
            pontos2.add(trajetoria1.getpontos().get(i));
        }
        Trajetoria t1 = new Trajetoria(pontos1);
        Trajetoria t2 = new Trajetoria(pontos2);
        t1.removeRep();
        t2.removeRep();
        pop.trajetorias.set(0,t1);
        pop.trajetorias.set(1,t2);
    }

    /**
     * @param p probabilidade
     */
    public void mutation(Random generator, double p){
        for(int i = 0; i< trajetorias.size(); i++) {
            for (int j = 1; j < trajetorias.get(i).getpontos().size(); j++) {
                if (trajetorias.get(i).getpontos().size() > 2) {
                    double random = generator.nextDouble(1);
                    if (random < p) {
                        int randomponto = generator.nextInt(trajetorias.get(i).getpontos().size() - 1) + 1;
                        Ponto p1 = new Ponto(generator.nextDouble(trajetorias.get(i).getpontos().get(j).x / 1.5, trajetorias.get(i).getpontos().get(j).x * 1.5), generator.nextDouble(trajetorias.get(i).getpontos().get(j).y / 1.5, trajetorias.get(i).getpontos().get(j).y * 1.5));
                        trajetorias.get(i).getpontos().set(randomponto, p1);
                        trajetorias.get(i).removeRep();
                    }
                }
            }
        }
        Populacao pop = new Populacao(trajetorias);
    }

    /**
     * @param p probabilidade
     */
    public void adition(Random generator, double p){
        for(int i = 0; i< trajetorias.size(); i++){
            for (int j = 1; j < trajetorias.get(i).getpontos().size(); j++) {
                double random = generator.nextDouble(1);
                if (random < p) {
                    int randomponto;
                    if (trajetorias.get(i).getpontos().size() > 2) {
                        randomponto = generator.nextInt(trajetorias.get(i).getpontos().size()) + 1;
                    } else {
                        randomponto = 1;
                    }
                    Ponto p1 = new Ponto(generator.nextDouble(trajetorias.get(i).getpontos().get(j).x / 1.5, trajetorias.get(i).getpontos().get(j).x * 1.5), generator.nextDouble(trajetorias.get(i).getpontos().get(j).y / 1.5, trajetorias.get(i).getpontos().get(j).y * 1.5));
                    trajetorias.get(i).getpontos().add(randomponto, p1);
                    trajetorias.get(i).removeRep();
                }
            }

        }
        Populacao pop = new Populacao(trajetorias);
    }

    /**
     * função que serve para remover pontos aleatoriamente
     * @param p probabilidade
     */
    public void remove(Random generator, double p){
        for(int i = 0; i< trajetorias.size(); i++){
            double random = generator.nextDouble(1);
            if(random < p){
                int randomponto;
                if(trajetorias.get(i).getpontos().size() > 2){
                    randomponto = generator.nextInt(trajetorias.get(i).getpontos().size() - 2 ) + 1;
                    trajetorias.get(i).getpontos().remove(randomponto);
                }
            }
        }
        Populacao pop = new Populacao(trajetorias);
    }

    /**
     * função que remove trajetorias que intercertem com os obstaculos
     * @param obstaculos
     */
    public void removehits(ArrayList<FiguraGeometrica> obstaculos){
        for(int i = 0; i < this.trajetorias.size(); i++){
            if(trajetorias.get(i).internum(obstaculos) > 0){
                trajetorias.remove(i);
                i++;
            }
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
