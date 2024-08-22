import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncrypterSmithTest {

    @Test
    void encrypt() {
        assertEquals("t{dwiKpecejgOgoq", EncrypterSmith.encrypt(2,2,"bugIncacheMemory"));
        assertEquals("DWvvgFrqwuroohueXj", EncrypterSmith.encrypt(-3,3,"bUgATssdController"));
        assertEquals("hexjlqfdfk", EncrypterSmith.encrypt(-9,3,"bugincache"));
        assertEquals("ZcvhjoNfNpS", EncrypterSmith.encrypt(1,1,"buginMeMoRY"));
    }

    @Test
    void decrypt() {
        assertEquals("bugIncacheMemory", EncrypterSmith.decrypt(2,2,"t{dwiKpecejgOgoq"));
        assertEquals("bUgATssdController", EncrypterSmith.decrypt(-3,3,"DWvvgFrqwuroohueXj"));
        assertEquals("buginMeMoRY", EncrypterSmith.decrypt(1,1,"ZcvhjoNfNpS"));
        assertEquals("bugincache", EncrypterSmith.decrypt(-9,3,"hexjlqfdfk"));
    }

    @Test
    void findKey() {
        assertArrayEquals(new int[] {2, 2}, EncrypterSmith.findKey("t{dwiKpecejgOgoq", "bug"));
        assertArrayEquals(new int[] {-3, 3}, EncrypterSmith.findKey("DWvvgFrqwuroohueXj", "bug"));
        assertArrayEquals(new int[] {1, 1}, EncrypterSmith.findKey("ZcvhjoNfNpS", "bug"));
        assertArrayEquals(new int[] {-9, 3}, EncrypterSmith.findKey("hexjlqfdfk", "bug"));
    }
}