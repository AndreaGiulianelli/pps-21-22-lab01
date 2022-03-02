import lab01.tdd.*;
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
        this.insertElements(10, 20);
        this.circularList.next();
        assertEquals(20, this.circularList.next().get());
    }

    @Test
    void nextTestCircularity() {
        this.insertElements(10, 20);
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
        this.insertElements(10, 20);
        assertEquals(20, this.circularList.previous().get());
    }

    @Test
    void testReset() {
        this.insertElements(10, 20);
        assertEquals(20, this.circularList.previous().get());
    }

    /**
     * Behaviour inspired to ListIterator where the
     * alternation of next and previous remains on the same element
     */
    @Test
    void testGeneralBehaviour() {
        this.insertElements(10, 20);
        this.circularList.next();
        assertEquals(10, this.circularList.previous().get());
    }

    @Test
    void testResetCurrentIndex() {
        this.insertElements(10, 20, 30);
        this.circularList.next();
        this.circularList.next();
        this.circularList.reset();
        assertEquals(10, this.circularList.next().get());
    }

    @Test
    void testEvenStrategy() {
        this.insertElements(1,2,3,4,5);
        this.circularList.next();
        this.circularList.next();
        assertEquals(4, this.circularList.next(new EvenStrategy()).get());
    }

    @Test
    void testMultipleOfStrategy() {
        this.insertElements(1,6,7);
        assertEquals(6, this.circularList.next(new MultipleOfStrategy(3)).get());
    }

    @Test
    void testEqualsStrategy() {
        this.insertElements(1,6,7);
        assertEquals(6, this.circularList.next(new EqualsStrategy(6)).get());
    }

    @Test
    void testEmptyEvenStrategy() {
        this.insertElements(1,3,7);
        assertEquals(Optional.empty(), this.circularList.next(new EvenStrategy()));
    }

    @Test
    void testEmptyMultipleOfStrategy() {
        this.insertElements(1,3,7);
        assertEquals(Optional.empty(), this.circularList.next(new MultipleOfStrategy(2)));
    }

    @Test
    void testEmptyEqualsStrategy() {
        this.insertElements(1,3,7);
        assertEquals(Optional.empty(), this.circularList.next(new EqualsStrategy(8)));
    }

    private void insertElements(final Integer... elements) {
        for(int element : elements) {
            this.circularList.add(element);
        }
    }
}
