/**@author 71353 Gonçalo Figueiredo
@version 1 21/02/2022
@inv as coordenadas têm que ser maiores ou iguais a 0
*/
class Ponto {
    double x, y;
/**@param coordenadas dos pontos*/
    Ponto(double x, double y) {
            this.x = x;
            this.y = y;
    }

/**@return retorna o valor da distância entre 2 pontos*/
    double dist (Ponto p) {

        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean verify(){
        return x >= 0 && y >=0;
    }
}