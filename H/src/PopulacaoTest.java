import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PopulacaoTest {

    @Test
    void testePontoToString() {
        Ponto ponto = new Ponto(10.5, 20.7);
        String expected = "(10;20)";
        assertEquals(expected, ponto.toString());
    }

    @Test
    void testeTrajetoriaToString() {
        ArrayList<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(10, 20));
        pontos.add(new Ponto(30, 40));
        pontos.add(new Ponto(50, 60));
        Trajetoria trajetoria = new Trajetoria(pontos);
        String expected = "[(10;20) (30;40) (50;60)]";
        assertEquals(expected, trajetoria.toString());
    }

}
