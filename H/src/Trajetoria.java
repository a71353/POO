/**@author 71353 Gonçalo Figueiredo
 * @version 1 21/02/2022
 *
 * */
import java.util.ArrayList;
import java.util.Random;

public class Trajetoria {
    private ArrayList<Ponto> ponto;

    public Trajetoria(ArrayList<Ponto> ponto) {
        this.ponto = ponto;
    }

    /**
     *
     * @return retorna a trejetoria no formato "[ ... ]"
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ponto.size(); i++) {
            sb.append(ponto.get(i).toString());
            if (i < ponto.size() - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}