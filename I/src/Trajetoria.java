/**@author 71353 Gonçalo Figueiredo
 * @version 1 21/02/2022
 * @inv tem que haver mais de 1 segmento para formar uma trajetoria
 * */

import java.util.ArrayList;
import java.util.List;

public class Trajetoria {

    private ArrayList<Ponto> ponto;

    /**
     *
     * @param arraylist de pontos
     */
    public Trajetoria(ArrayList<Ponto> ponto) {
        this.ponto = ponto;
    }

    public ArrayList<Ponto> getpontos(){
        return ponto;
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
    public boolean vertraj(){
        if(ponto.size() < 3){
            return false;
        }
        int n = ponto.size();
        for(int i = 1; i < n; i++) {
            if (ponto.get(i-1).x > ponto.get(i).x && ponto.get(i-1).y > ponto.get(i).y){
                return false;
            }
        }
        return true;
    }/**@return retorna false se existir menos de 2 segmentos e se o proximo ponto for menor que o anterior
 */
    /**
     *
     * @return retorna a distancia entre todos os pontos da trajetoria somados
     */
    public double distance(){
        double dist = 0;
        for(int i = 0; i < ponto.size()-1; i++){
            dist += ponto.get(i).dist(ponto.get(i+1));
        }
        return dist;
    }

    /**
     * @param figuraGeometricas obstaculos
     * @return o numero de obstaculos intercetados
     */
    public int internum(List<FiguraGeometrica> figuraGeometricas){
        int num=0;
        for(FiguraGeometrica fig: figuraGeometricas){
            if(fig.intercecao(this)){
                num++;
            }
        }
        return num;
    }

    /**
     * @param figuraGeometricas obstaculos
     * @return retorna a avaliação da trajetoria
     */
    public double avaluation(List<FiguraGeometrica> figuraGeometricas){
        double dist = this.distance();
        int num = this.internum(figuraGeometricas);
        return 1/(dist + Math.exp(num));

    }

}
