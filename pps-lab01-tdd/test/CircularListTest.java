import lab01.tdd.model.BasicCircularList;
import lab01.tdd.model.CircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.CircularListTestUtils;

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
        CircularListTestUtils.insertElements(this.circularList, 10, 20);
        this.circularList.next();
        assertEquals(20, this.circularList.next().get());
    }

    @Test
    void nextTestCircularity() {
        CircularListTestUtils.insertElements(this.circularList,10, 20);
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
        CircularListTestUtils.insertElements(this.circularList,10, 20);
        assertEquals(20, this.circularList.previous().get());
    }

    @Test
    void testReset() {
        CircularListTestUtils.insertElements(this.circularList,10, 20);
        assertEquals(20, this.circularList.previous().get());
    }

    /**
     * Behaviour inspired to ListIterator where the
     * alternation of next and previous remains on the same element
     */
    @Test
    void testGeneralBehaviour() {
        CircularListTestUtils.insertElements(this.circularList,10, 20);
        this.circularList.next();
        assertEquals(10, this.circularList.previous().get());
    }

    @Test
    void testResetCurrentIndex() {
        CircularListTestUtils.insertElements(this.circularList,10, 20, 30);
        this.circularList.next();
        this.circularList.next();
        this.circularList.reset();
        assertEquals(10, this.circularList.next().get());
    }
}
