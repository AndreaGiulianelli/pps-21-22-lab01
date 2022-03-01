import lab01.tdd.BasicCircularList;
import lab01.tdd.CircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularList circularList;

    @BeforeEach
    void setUp() {
        this.circularList = new BasicCircularList();
    }

    @Test
    void isInitiallyEmpty() {
        assertTrue(this.circularList.isEmpty() && this.circularList.size() == 0);
    }

    @Test
    void addElementIncreaseSize() {
        this.circularList.add(10);
        assertTrue(!this.circularList.isEmpty() && this.circularList.size() == 1);
    }
}
