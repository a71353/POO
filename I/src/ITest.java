import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Test {
    @Test
    public void testAvaluation() {
        // Cria uma trajetória simples
        ArrayList<Ponto> pontos1 = new ArrayList<>();
        pontos1.add(new Ponto(1, 2));
        pontos1.add(new Ponto(4, 3));
        pontos1.add(new Ponto(5, 5));
        pontos1.add(new Ponto(6, 10));
        pontos1.add(new Ponto(10, 6));
        Trajetoria trajetoria1 = new Trajetoria(pontos1);

        // Cria uma figura geométrica simples
        FiguraGeometrica figura1 = new Circunferencia("Circunferencia 10 10 3");
        FiguraGeometrica figura2 = new Triangulo("Triangulo 0 0 2 0 3 3");
        FiguraGeometrica figura3 = new Retangulo("Retangulo 4 4 6 4 6 6 4 6");
        // Cria uma lista com a figura geométrica acima
        List<FiguraGeometrica> figuras = new ArrayList<>();
        figuras.add(figura1);
        figuras.add(figura2);
        figuras.add(figura3);

        assertEquals(0.027594004525338705, trajetoria1.avaluation(figuras));
    }
}
