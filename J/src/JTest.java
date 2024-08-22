import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class JTest {

    @Test
    public void testOrden() {
        // Cria uma lista de figuras geométricas para avaliação das trajetórias
        List<FiguraGeometrica> fig = new ArrayList<>();
        fig.add(new Circunferencia("Circunferencia 10 10 3"));
        fig.add(new Triangulo("Triangulo 0 0 2 0 3 3"));
        fig.add(new Retangulo("Retangulo 4 4 6 4 6 6 4 6"));

        // Cria uma população de trajetórias para teste
        Populacao p = new Populacao(3, new int[]{4, 7, 5}, new Ponto(2, 4), new Ponto(34, 18));

        // Ordena a população
        p.orden(fig);

        assertEquals("[(2;4) (24;47) (52;60) (3;82) (92;23) (45;45) (34;18)]\n" +
                "[(2;4) (24;47) (52;60) (3;82) (92;23) (45;45) (34;18)]\n" +
                "[(2;4) (60;48) (29;47) (15;53) (91;61) (34;18)]", p.toString());
    }
}
