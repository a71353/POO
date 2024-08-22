import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Ltest {

    @Test
    public void testMutationProbability0() {
        // Test mutation with probability 0
        int[] traj = {3, 4, 5};
        Populacao pop = new Populacao(traj.length, traj);
        Populacao popMutated = pop.mutation(0.0);
        assertEquals("[(60;48) (29;47) (15;53)]\n[(91;61) (19;54) (77;77) (73;62)]\n[(95;44) (84;75) (41;20) (43;88) (24;47)]", popMutated.toString());
    }

    @Test
    public void testMutationProbability1() {
        // Test mutation with probability 1
        int[] traj = {3, 4, 5};
        Populacao pop = new Populacao(traj.length, traj);
        Populacao popMutated = pop.mutation(1.0);
        assertNotEquals(pop, popMutated.toString());
    }

    @Test
    public void testMutationProbabilityHalf() {
        // Test mutation with probability 0.5
        int[] traj = {3, 4, 5};
        Populacao pop = new Populacao(traj.length, traj);
        Populacao popMutated = pop.mutation(0.5);
        assertNotNull(popMutated.toString());
    }

    @Test
    public void testMutationWithEmptyTrajetorias() {
        // Test mutation with empty list of trajectories
        int[] traj = {};
        Populacao pop = new Populacao(traj.length, traj);
        Populacao popMutated = pop.mutation(0.5);
        assertEquals(pop.toString(), popMutated.toString());
    }
}
