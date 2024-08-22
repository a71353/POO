import java.util.ArrayList;

/**
 * A classe Gestor é responsável por gerenciar a lista de robots disponíveis para entrega. E escolher o robot certo para fazer a entrega.
 * @author Gonçalo Figueiredo 71353
 * @author António Afonso 71351
 * @version 05/05/2023
 */
public class Gestor {
    private ArrayList<Robot> robots;

    public Gestor(ArrayList<Robot> robots) {
        this.robots = robots;
    }

    /**
     * O método escolher Robot escolhe o robot mais adequado para realizar a entrega com base na sua energia necessária e disponibilidade.
     * @return o índice do robot escolhido na lista de robots disponíveis para entrega.
     */
    public int escolherRobot() {
        int indiceEscolhido = -1;
        double menorEnergia = Double.MAX_VALUE;
        for (int i = 0; i < this.robots.size(); i++) {
            Robot r = this.robots.get(i);
            r.hasEnoughEnergyToEncomenda();
            ArrayList<Double> energyneeded = r.energyneeded();
            if (!energyneeded.isEmpty()) {
                int indiceMinimo = r.encontrarIndiceMinimo();
                double energiaGasta = energyneeded.get(indiceMinimo);
                if (energiaGasta < menorEnergia) {
                    indiceEscolhido = i;
                    menorEnergia = energiaGasta;
                }
            }
        }
        return indiceEscolhido;
    }


    /**
     *
     * @return lista de robots disponiveis
     */
    public ArrayList<Robot> robots(){
        return robots;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < robots.size(); i++) {
            double batteryLevel = robots.get(i).battery();
            result.append(String.format("%.2f", batteryLevel)).append(", ");
        }

        if (result.length() > 0) {
            // Remove a vírgula e o espaço extras no final
            result.setLength(result.length() - 2);
        }

        return result.toString();
    }

}
