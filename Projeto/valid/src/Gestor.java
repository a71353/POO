import java.util.ArrayList;

/**
 * A classe Gestor é responsável por gerenciar a lista de robots disponíveis para entrega. E escolher o robot certo para fazer a entrega.
 * @author Gonçalo Figueiredo 71353
 * @author António Afonso 71351
 * @version 05/05/2023
 */
public class Gestor {
    private ArrayList<Robot> robots;

    private Robot robot;
    public Gestor(ArrayList<Robot> robots) {
        this.robots = robots;
    }

    public Gestor(Robot robot){
        this.robot = robot;
    }

    /**
     * O método escolher Robot escolhe o robot mais adequado para realizar a entrega com base na sua energia necessária e disponibilidade.
     * @return o índice do robot escolhido na lista de robots disponíveis para entrega.
     */


    public int getRobotWithMinBattery() {
        int minIndex = 0;
        double minBattery = robots.get(0).batteryNeeded();

        for (int i = 1; i < robots.size(); i++) {
            double battery = robots.get(i).batteryNeeded();
            if (battery < minBattery) {
                minBattery = battery;
                minIndex = i;
            }
        }

        return minIndex;
    }

    public void ver() {
        boolean algumRoboTemBateria = false;

            double bateriaNecessaria = robot.batteryNeeded();
            double bateriaRestante = robot.battery() - bateriaNecessaria;

            if (bateriaRestante > 0) {
                algumRoboTemBateria = true;
            }
        if (!algumRoboTemBateria) {
            System.out.println("imp");
            System.exit(0);
        }
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
