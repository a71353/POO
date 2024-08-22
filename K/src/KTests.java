import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class KTests {


    @Test
    public void testCortada() {
        // Criar duas trajetórias válidas
        ArrayList<Ponto> pontos1 = new ArrayList<>();
        pontos1.add(new Ponto(2, 1));
        pontos1.add(new Ponto(3, 4));
        pontos1.add(new Ponto(6, 8));
        pontos1.add(new Ponto(8, 2));
        Trajetoria traj1 = new Trajetoria(pontos1);

        ArrayList<Ponto> pontos2 = new ArrayList<>();
        pontos2.add(new Ponto(1, 1));
        pontos2.add(new Ponto(2, 3));
        pontos2.add(new Ponto(3, 4));
        Trajetoria traj2 = new Trajetoria(pontos2);

        ArrayList<Trajetoria> trajetorias = new ArrayList<>();
        trajetorias.add(traj1);
        trajetorias.add(traj2);

        Populacao pop = new Populacao(trajetorias);

        pop.cortada(pop);

        // Verificar se a lista de trajetórias da população foi corretamente atualizada
        assertEquals("[(2;1) (3;4)]\n[(1;1) (2;3) (3;4) (6;8) (8;2)]", pop.toString());

        ArrayList<Ponto> pontos3 = new ArrayList<>();
        pontos3.add(new Ponto(3, 4));
        pontos3.add(new Ponto(8, 7));
        Trajetoria traj3 = new Trajetoria(pontos3);

        ArrayList<Ponto> pontos4 = new ArrayList<>();
        pontos4.add(new Ponto(2, 3));
        pontos4.add(new Ponto(3, 4));
        Trajetoria traj4 = new Trajetoria(pontos4);

        ArrayList<Trajetoria> trajetorias1 = new ArrayList<>();
        trajetorias1.add(traj3);
        trajetorias1.add(traj4);

        Populacao pop1 = new Populacao(trajetorias1);

        pop1.cortada(pop1);

        assertEquals("[(3;4)]\n[(2;3) (8;7)]", pop1.toString());

        ArrayList<Ponto> pontos5 = new ArrayList<>();
        pontos5.add(new Ponto(1, 2));
        pontos5.add(new Ponto(2, 4));
        pontos5.add(new Ponto(8, 5));
        pontos5.add(new Ponto(3, 5));
        Trajetoria traj5 = new Trajetoria(pontos5);

        ArrayList<Ponto> pontos6 = new ArrayList<>();
        pontos6.add(new Ponto(2, 3));
        pontos6.add(new Ponto(3, 4));
        pontos6.add(new Ponto(3, 6));
        pontos6.add(new Ponto(3, 7));
        pontos6.add(new Ponto(2, 8));
        Trajetoria traj6 = new Trajetoria(pontos6);

        ArrayList<Trajetoria> trajetorias2 = new ArrayList<>();
        trajetorias2.add(traj5);
        trajetorias2.add(traj6);

        Populacao pop2 = new Populacao(trajetorias2);

        pop2.cortada(pop2);

        assertEquals("[(1;2) (2;8)]\n[(2;3) (3;4) (3;6) (3;7) (2;4) (8;5) (3;5)]", pop2.toString());
    }

}
