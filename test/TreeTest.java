import org.junit.Test;

// place your cursor over junit below and
// click "Add 'Junit4' to classpath" then press OK to be able to run this test.
import static org.junit.Assert.assertTrue;

/**
 * A template for a test class in case you decide to write any.
 * The basic structure is the same as pytest which you've used in the past.
 * We'll talk more about testing soon in lecture.
 */
public class TreeTest {

    @Test(timeout = 500)
    public void dummyTest() {
        assertTrue(true);
    }

    public static void main(String[] args) {
        // Run the tests
        org.junit.runner.JUnitCore.main(TreeTest.class.getName());
    }

}