import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RecursionHiTest {

    @Test
    public void testCount1() {
        // Test cases
        assertEquals(0, RecursionHi.countHi(null));

    }

    @Test
    public void testCount2() {
        // Test cases
        assertEquals(1, RecursionHi.countHi("xhinwaou"));

    }

    @Test
    public void testCount3() {
        // Test cases
        assertEquals(1, RecursionHi.countHi("18y9412hi"));

    }

    @Test
    public void testCount4() {
        // Test cases
        assertEquals(0, RecursionHi.countHi("xihx"));

    }

    @Test
    public void testCount5() {
        // Test cases
        assertEquals(0, RecursionHi.countHi(" "));

    }

    @Test
    public void testCount6() {
        // Test cases
        assertEquals(0, RecursionHi.countHiNextToX("xxhixx"));

    }

    @Test
    public void testCount7() {
        // Test cases
        assertEquals(1, RecursionHi.countHiNextToX("hixx"));

    }

    @Test
    public void testCount8() {
        // Test cases
        assertEquals(1, RecursionHi.countHiNextToX("17hixx"));

    }

    @Test
    public void testCount9() {
        // Test cases
        assertEquals(0, RecursionHi.countHiNextToX(" "));

    }

    @Test
    public void testCount10() {
        // Test cases
        assertEquals(0, RecursionHi.countHiNextToX(null));

    }

}
