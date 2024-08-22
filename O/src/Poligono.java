

import java.util.ArrayList;

public class Poligono extends FiguraGeometrica{
    protected ArrayList<Ponto> pontos = new ArrayList<Ponto>();             //protected é tipo private, mas os filhos tem acesso aos metodos
    protected ArrayList<SegmentoReta> segmentos= new ArrayList<SegmentoReta>();


    /**
     * Este método serve para verificar se o segmento de reta toca em algum segmento de reta do poligono
     * @param seg é o segmento de reta usado para verificar
     * @return é um booleano que diz se esse segmento toca ou não
     */
    public boolean verificacao(SegmentoReta seg){
        for(int i=0;i<this.segmentos.size();i++){
            if(seg.vericacaoSegmentoReta(this.segmentos.get(i)))
                return true;
        }
        return false;
    }

    /**
     * Este método, com ajuda do metodo de verificao, diz que o segmento de reta toca ou não no poligono (caso ele acerte
     * no poligono diz " fail" e diz "ok" caso contrário.
     * @param seg é o segmento usado para testar
     * @return retorna a uma string que nos diz o resultado
     */
    public String stringToPrint(SegmentoReta seg){
        String print;
        if(verificacao(seg))
            print="Fail";
        else
            print="Ok";
        return print;
    }

}
