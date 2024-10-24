
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RecursionTest {

    @Test
    public void testCount1() {
        // Test cases
        assertEquals(1, Recursion.count8(8));
    }

    @Test
    public void testCount2() {
        // Test cases
        assertEquals(9, Recursion.count8(888888888));
    }

    @Test
    public void testCount3() {
        // Test cases
        assertEquals(0, Recursion.count8(12345679));
    }

    @Test
    public void testCount4() {
        // Test cases
        assertEquals(2, Recursion.count8(8018));
    }

    @Test
    public void testCount5() {
        // Test cases
        assertEquals(5, Recursion.count8(818181818));
    }
}
