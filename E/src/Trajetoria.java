/**@author 71353 Gonçalo Figueiredo
 * @version 1 21/02/2022
 * @inv tem que haver mais de 1 segmento para formar uma trajetoria
 * @param lista de segmentos de reta
 * */

import java.util.List;

public class Trajetoria {

    private List<SegReta> seg;


    public Trajetoria(List<SegReta> seg) {
        this.seg = seg;
    }

    public boolean vertraj(){
        if(seg.size() < 2){
            return false;
        }
        int n = seg.size();
        for(int i = 1; i < n; i++) {
            if (seg.get(i-1).getP1().x > seg.get(i).getP1().x && seg.get(i-1).getP1().y > seg.get(i).getP1().y){
                return false;
            }
        }
        return true;
    }/**@return retorna false se existir menos de 2 segmentos e se o proximo ponto for menor que o anterior
 */

    public int intersections(List<Retangulo> retangulos){
        int count = 0;

        for (int j = 0; j < retangulos.size(); j++) {
            for (int i = 0; i < seg.size(); i++) {
                if (seg.get(i).getP1().x == seg.get(i).getP2().x) {
                    if (((seg.get(i).getP1().x >= retangulos.get(j).getP1().x && seg.get(i).getP1().x <= seg.get(i).getP2().x) && (seg.get(i).getP1().y <= retangulos.get(j).getP1().y && seg.get(i).getP2().y >= retangulos.get(j).getP1().y)) || ((seg.get(i).getP1().x >= retangulos.get(j).getP4().x && seg.get(i).getP1().x <= retangulos.get(j).getP3().x) && (seg.get(i).getP1().y <= retangulos.get(j).getP4().y && seg.get(i).getP2().y >= retangulos.get(j).getP4().y))) {
                        count++;
                    }
                    break;
                }
                if (retangulos.get(j).getLado1().interceta(seg.get(i))) {
                    count++;
                    break;
                }
                if (retangulos.get(j).getLado2().interceta(seg.get(i))) {
                    count++;
                    break;
                }
                if (retangulos.get(j).getLado3().interceta(seg.get(i))) {
                    count++;
                    break;
                }
                if (retangulos.get(j).getLado4().interceta(seg.get(i))) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}
