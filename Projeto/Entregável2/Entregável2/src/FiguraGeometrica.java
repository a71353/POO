import java.awt.*;

/**
 * A classe Figura Geometrica é uma classe abstrata que define o comportamento de objetos que representam figuras geométricas.
 * @author Gonçalo Figueiredo 713533
 * @version 21/02/2022
 */
public abstract class FiguraGeometrica{

        public FiguraGeometrica(String s){}

        public abstract boolean intercecao(Trajetoria trajetoria);

        public abstract void verifica();

        public abstract void desenha(Graphics g);

}
