public class Reta {
    /**
     * @autor Goncalo Figueiredo
     * @version 1
     * */
    private Ponto ponto1,ponto2;
    private double m,b;

    /**
     * Este método é o construtor da classe reta, que necesita de receber 2 pontos.E posteriormente calcula o m e o b
     * de cada reta.
     * @param ponto1 ponto inicial necessário para a criação da reta
     * @param ponto2 ponto final necessário para a criação da reta
     */
    public Reta(Ponto ponto1,Ponto ponto2){
        this.ponto1=ponto1;
        this.ponto2=ponto2;                                                      //NAO ESQUECER DE QUANDO É 0/0 OU SEJA TEMOS QUE MUDAR A EQUACAO DA RETA
        if((ponto2.getX()-ponto1.getX()!=0)){                                   //serve para ver se não fica a dividir por 0
            this.m=(ponto2.getY()-ponto1.getY())/(ponto2.getX()-ponto1.getX());
            this.b=ponto1.getY()-m*ponto1.getX();
        }
    }

    /**
     * Este método verifica,onde 2 retas obliquas se intersetam, e posteriormente vê se elas se encontram dentro dos
     * limites dos segmentos de retas.
     * @param a reta necessária para verificar a interseção com a reta dada pelo construtor
     * @return retorna true, se as retas se intersetam dentro dos valores estabelecidos para os segmentos de reta.E
     * retorna falso caso contrário.
     */
    public boolean intersecaoRETA(Reta a)                // ver o x onde as retas se intersetam e caso contrario retorna -1
    {
        boolean f= false;
        double z = m - a.m;
        double w = a.b - b;
        if(z!=0){
            double result;
            result = w / z;
            if(((result<=Math.max(a.ponto1.getX(),a.ponto2.getX())) && (result>=Math.min(a.ponto1.getX(),a.ponto2.getX()))) && ((result<=Math.max(ponto1.getX(),ponto2.getX())) && (result>=Math.min(ponto1.getX(),ponto2.getX())) ))
                f=true;
        }
        return f;
    }
    /**
     * Este método verifica,se 2 retas horizontais ou 2 retas paralelas se intersetam, e posteriormente vê se elas se
     * encontram dentro limites dos segmentos de retas.
     * @param a reta necessária para verificar a interseção com a reta dada pelo construtor
     * @return retorna true, se as retas se intersetam dentro dos valores estabelecidos para os segmentos de reta.E
     * retorna falso caso contrário.
     */

    public boolean intersecaoPARELAHORIZONTAL(Reta a){           // ver o x onde as retas se intersetam no caso de serem paralelas ou horizontais
        boolean f= false;                                              // result vale -10 caso contrario retorna -1
        if(b==a.b){
            if((ponto1.getX()<=Math.max(a.ponto1.getX(),a.ponto2.getX())) && (ponto1.getX()>=Math.min(a.ponto1.getX(),a.ponto2.getX())))
                f=true;
            else if((ponto2.getX()<=Math.max(a.ponto1.getX(),a.ponto2.getX())) && (ponto2.getX()>=Math.min(a.ponto1.getX(),a.ponto2.getX())))
                f=true;
            else if((a.ponto1.getX()<=Math.max(ponto1.getX(),ponto2.getX())) && (a.ponto1.getX()>=Math.min(ponto1.getX(),ponto2.getX())))
                f=true;
            else if((a.ponto2.getX()<=Math.max(ponto1.getX(),ponto2.getX())) && (a.ponto2.getX()>=Math.min(ponto1.getX(),ponto2.getX())))
                f=true;
        }
        return f;
    }
    /**
     * Este método verifica,se 2 retas verticais se intersetam, e posteriormente vê se elas se
     * encontram dentro dos limites dos segmentos de retas.
     * @param a reta necessária para verificar a interseção com a reta dada pelo construtor
     * @return retorna true, se as retas se intersetam dentro dos valores estabelecidos para os segmentos de reta.E
     * retorna falso caso contrário.
     */
    public boolean intersecaoVERTICAIS(Reta a){                                      // SE ISTO ACONTECER AS RETAS SAO VERTICAIS
        boolean f=false;                                                                  // RETORNA O XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        if(ponto1.getX()==a.ponto1.getX()){                                             // CASO SEJAM 2 RETAS VERTICAIS, SE OS X FOREM OS MESMOS, VAMOS PARA AS CONDICOES
            if((ponto1.getY()<=Math.max(a.ponto1.getY(),a.ponto2.getY())) && (ponto1.getY()>=Math.min(a.ponto1.getY(),a.ponto2.getY())))
                f=true;
            else if((ponto2.getY()<=Math.max(a.ponto1.getY(),a.ponto2.getY())) && (ponto2.getY()>=Math.min(a.ponto1.getY(),a.ponto2.getY())))
                f=true;
            else if((a.ponto1.getY()<=Math.max(ponto1.getY(),ponto2.getY())) && (a.ponto1.getY()>=Math.min(ponto1.getY(),ponto2.getY())))
                f=true;
            else if((a.ponto2.getY()<=Math.max(ponto1.getY(),ponto2.getY())) && (a.ponto2.getY()>=Math.min(ponto1.getY(),ponto2.getY())))
                f=true;
        }
        return f;
    }
    /**
     * Este método verifica,se 1 retas vertical e outra horizontal se intersetam, e posteriormente vê se elas se
     * encontram dentro dos limites dos segmentos de retas.
     * @param a reta necessária para verificar a interseção com a reta dada pelo construtor
     * @return retorna true, se as retas se intersetam dentro dos valores estabelecidos para os segmentos de reta.E
     * retorna falso caso contrário.
     */
    public boolean intersecaoVERTICALHORIZONTAL(Reta a){
        boolean f=false;
        if((a.ponto1.getX()<=Math.max(ponto1.getX(),ponto2.getX()) && a.ponto1.getX()>=Math.min(ponto1.getX(),ponto2.getX())) && (ponto1.getY()<=Math.max(a.ponto1.getY(),a.ponto2.getY()) && ponto1.getY()>=Math.min(a.ponto1.getY(),a.ponto2.getY())))
            f=true;
        else if((a.ponto2.getX()<=Math.max(ponto1.getX(),ponto2.getX()) && a.ponto2.getX()>=Math.min(ponto1.getX(),ponto2.getX())) && (ponto2.getY()<=Math.max(a.ponto1.getY(),a.ponto2.getY()) && ponto2.getY()>=Math.min(a.ponto1.getY(),a.ponto2.getY())))
            f=true;
        else if((ponto1.getX()<=Math.max(a.ponto1.getX(),a.ponto2.getX()) && ponto1.getX()>=Math.min(a.ponto1.getX(),a.ponto2.getX())) && (a.ponto1.getY()<=Math.max(ponto1.getY(),ponto2.getY()) && a.ponto1.getY()>=Math.min(ponto1.getY(),ponto2.getY())))
            f=true;
        else if((ponto2.getX()<=Math.max(a.ponto1.getX(),a.ponto2.getX()) && ponto2.getX()>=Math.min(a.ponto1.getX(),a.ponto2.getX())) && (a.ponto2.getY()<=Math.max(ponto1.getY(),ponto2.getY()) && a.ponto2.getY()>=Math.min(ponto1.getY(),ponto2.getY())))
            f=true;
        else
            f=false;
        return f;
    }
    /**
     * Este método verifica,se 1 retas vertical e outra obliqua se intersetam, e posteriormente vê se elas se
     * encontram dentro dos limites dos segmentos de retas.
     * @param a reta necessária para verificar a interseção com a reta dada pelo construtor
     * @return retorna true, se as retas se intersetam dentro dos valores estabelecidos para os segmentos de reta.E
     * retorna falso caso contrário.
     */
    public boolean intersecaoOBLIQUAVERTICAL(Reta a){
        boolean f= false;
        double y=m*a.ponto1.getX()+b;           // caso a vertical
        double y1=a.m*ponto1.getX() +a.b;       // caso a obliqua           // vemos quando o y está compreendido entre os Y da reta vertical e entre os Y da reta obliqua, e depois se o X do ponto a esta compreendida entre entre o X entre a reta obliqua
        if((y<=Math.max(a.ponto1.getY(),a.ponto2.getY()) && y>=Math.min(a.ponto1.getY(),a.ponto2.getY())) && (y<=Math.max(ponto1.getY(),ponto2.getY()) && y>=Math.min(ponto1.getY(),ponto2.getY())) && (a.ponto1.getX()<=Math.max(ponto1.getX(),ponto2.getX())) && (a.ponto1.getX()>=Math.min(ponto1.getX(),ponto2.getX())))
            f=true;
        else if((y1<=Math.max(a.ponto1.getY(),a.ponto2.getY()) && y1>=Math.min(a.ponto1.getY(),a.ponto2.getY())) && (y1<=Math.max(ponto1.getY(),ponto2.getY()) && y1>=Math.min(ponto1.getY(),ponto2.getY())) && ((ponto1.getX()<=Math.max(a.ponto1.getX(),a.ponto2.getX())) &&(ponto1.getX()>=Math.min(a.ponto1.getX(),a.ponto2.getX()))))
            f=true;
        return f;
    }

    /**
     * Este método vai verificar que tipo de retas é que que estão a ser analizadas, e chama a respetiva função correta
     * para verificar se elas se tocam ou não dentro dos limites estabelecidos.
     * @param a a reta necessária para verificar a interseção com a reta dada pelo construtor
     * @return retorna true, se as retas se intersetam dentro dos valores estabelecidos para os segmentos de reta.E
     * retorna falso caso contrário.
     */

    public boolean retacerta(Reta a){
        boolean f=false;
        if(ponto2.getX()-ponto1.getX()==0 && a.ponto2.getX()-a.ponto1.getX()==0)
            f=intersecaoVERTICAIS(a);
        else if((m==0 && a.ponto2.getX()-a.ponto1.getX()==0) || (a.m==0 && ponto2.getX()-ponto1.getX()==0))
            f=intersecaoVERTICALHORIZONTAL(a);
        else if(m -a.m==0)
            f=intersecaoPARELAHORIZONTAL(a);
        else if(((a.ponto2.getX()-a.ponto1.getX()==0)&& ponto2.getX()-ponto1.getX()!=0) || ((ponto2.getX()-ponto1.getX()==0) && (a.ponto2.getX()-a.ponto1.getX()!=0)))
            f=intersecaoOBLIQUAVERTICAL(a);
        else
            f=intersecaoRETA(a);
        return f;
    }
    /**
     * Este método retorna o ponto1
     * @return retorna o ponto1
     */


    public Ponto getPonto1() {
        return ponto1;
    }
    /**
     * Este método retorna o ponto2
     * @return retorna o ponto2
     */
    public Ponto getPonto2() {
        return ponto2;
    }
    /**
     * Este método,serve para definifir um valor novo para o ponto1
     */

    public void setPonto1(Ponto ponto1) {
        this.ponto1 = ponto1;
    }
    /**
     * Este método,serve para definifir um valor novo para o ponto2
     */
    public void setPonto2(Ponto ponto2) {
        this.ponto2 = ponto2;
    }

    /**
     * este método retorna o m
     * @return m
     */
    public double m() {
        return m;
    }

    /**
     * este método retorna o b
     * @return retorna o b
     */
    public double b() {
        return b;
    }

}
