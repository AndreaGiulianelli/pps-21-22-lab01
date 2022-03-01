import lab01.tdd.BasicCircularList;
import lab01.tdd.CircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void nextInitiallyEmpty() {
        assertEquals(Optional.empty(), this.circularList.next());
    }

    @Test
    void previousInitiallyEmpty() {
        assertEquals(Optional.empty(), this.circularList.previous());
    }

    @Test
    void nextTestOneElement() {
        this.circularList.add(10);
        assertEquals(10, this.circularList.next().get());
    }

    @Test
    void testNextElement() {
        this.circularList.add(10);
        this.circularList.add(20);
        this.circularList.next();
        assertEquals(20, this.circularList.next().get());
    }

    @Test
    void nextTestCircularity() {
        this.circularList.add(10);
        this.circularList.add(20);
        this.circularList.next();
        this.circularList.next();
        assertEquals(10, this.circularList.next().get());
    }

    @Test
    void previousTestOneElement() {
        this.circularList.add(10);
        assertEquals(10, this.circularList.previous().get());
    }

    @Test
    void testPreviousElement() {
        this.circularList.add(10);
        this.circularList.add(20);
        assertEquals(20, this.circularList.previous().get());
    }
}
