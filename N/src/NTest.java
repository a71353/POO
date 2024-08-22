import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NTest {

    @Test
    public void testremove() {
        int[] traj = {2, 3};
        Populacao pop = new Populacao(traj.length, traj);
        Populacao poprem = pop.remove(0.0);
        assertEquals("[(60;48) (29;47)]\n[(15;53) (91;61) (19;54)]", poprem.toString());
    }

    @Test
    public void testremoe1() {
        int[] traj = {2, 3};
        Populacao pop = new Populacao(traj.length, traj);
        Populacao poprem = pop.remove(0.75);
        assertEquals("[(60;48) (29;47)]\n[(15;53) (19;54)]", poprem.toString());
    }

}