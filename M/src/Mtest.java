import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Mtest {

    @Test
    public void testadition() {
        int[] traj = {2, 3};
        Populacao pop = new Populacao(traj.length, traj);
        Populacao popadded = pop.adition(0.5);
        assertEquals("[(60;48) (73;62) (29;47)]\n[(15;53) (91;61) (19;54)]", popadded.toString());
    }

    @Test
    public void testadition1() {
        int[] traj = {2, 3};
        Populacao pop = new Populacao(traj.length, traj);
        Populacao popadded = pop.adition(0.0);
        assertEquals("[(60;48) (29;47)]\n[(15;53) (91;61) (19;54)]", popadded.toString());
    }

}
