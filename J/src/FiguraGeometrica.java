/**
 * @author 71353 Gonçalo Figueiredo
 */
public abstract class FiguraGeometrica{
        /**
         * @param s string com o nome da classe e os pontos
         */
        public FiguraGeometrica(String s){}

        /**
         * @param trajetoria
         * @return true se intersetar false se nao
         */
        public abstract boolean intercecao(Trajetoria trajetoria);

        public abstract void verifica();


}
