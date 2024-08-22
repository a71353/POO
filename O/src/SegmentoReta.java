public class SegmentoReta {
    /**
     * @autor Goncalo Figueiredo
     * @version 1
     * */
    private Ponto ponto1,ponto2;
    private Reta r;

    /**
     * Este segmento é o construtor do segmento de reta que necessita 2 pontos para ser criado.Cria também uma reta r
     * com base nos pontos dados para a criação de um segmento de reta
     * @param ponto1 é o ponto inicial fornecido para a criação do segmento de reta
     * @param ponto2 é o ponto final fornecido para a criação do segmento de reta
     */
    public SegmentoReta(Ponto ponto1,Ponto ponto2){
        this.ponto1=ponto1;
        this.ponto2=ponto2;                                                      //NAO ESQUECER DE QUANDO É 0/0 OU SEJA TEMOS QUE MUDAR A EQUACAO DA RETA
        if(ponto1.getX()==ponto2.getX() && ponto1.getY()==ponto2.getY()){
            System.out.println("Segmento:vi");                                   //caso o segmento de reta não exista
            System.exit(0);
        }
        r= new Reta(ponto1,ponto2);
    }
    /**
     * Este método serve, para verificar se os segmentos de reta se intersetam, com auxilio de 2 retas criadas a
     * partir dos segmentos de reta
     * @param a segmento de reta criado com base nos 2 pontos dados
     * @return retorna true se o segmento de reta dado, toca em algum dos segmentos de reta dos retangulos.
     */
    public boolean vericacaoSegmentoReta(SegmentoReta a){
        if(this.r.retacerta(a.r))
            return true;
        return false;
    }

    /**
     * retorna o ponto1 do segmento
     * @return o primeiro ponto do segmento
     */
    public Ponto ponto1() {
        return ponto1;
    }

    /**
     * retorna o ponto2 do segmento
     * @return o ultimo ponto do segmento
     */
    public Ponto ponto2() {
        return ponto2;
    }

    /**
     * serve para retornar uma reta com base nos 2 pontos dados
     * @return retorna uma reta r
     */
    public Reta r() {
        return r;
    }

}
