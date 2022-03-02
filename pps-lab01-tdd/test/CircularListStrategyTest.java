import lab01.tdd.model.BasicCircularList;
import lab01.tdd.model.CircularList;
import lab01.tdd.model.strategy.factory.SelectStrategyFactory;
import lab01.tdd.model.strategy.factory.SelectStrategyFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.CircularListTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the CircularList next with strategy functionality
 */
public class CircularListStrategyTest {
    private CircularList circularList;
    private SelectStrategyFactory strategyFactory;

    @BeforeEach
    void setUp() {
        this.circularList = new BasicCircularList();
        this.strategyFactory = new SelectStrategyFactoryImpl();
    }

    @Test
    void testEvenStrategy() {
        CircularListTestUtils.insertElements(this.circularList,1,2,3,4,5);
        this.circularList.next();
        this.circularList.next();
        assertEquals(4, this.circularList.next(this.strategyFactory.createEvenStrategy()).get());
    }

    @Test
    void testMultipleOfStrategy() {
        CircularListTestUtils.insertElements(this.circularList,1,6,7);
        assertEquals(6, this.circularList.next(this.strategyFactory.createMultipleOfStrategy(3)).get());
    }

    @Test
    void testEqualsStrategy() {
        CircularListTestUtils.insertElements(this.circularList,1,6,7);
        assertEquals(6, this.circularList.next(this.strategyFactory.createEqualsStrategy(6)).get());
    }

    @Test
    void testEmptyEvenStrategy() {
        CircularListTestUtils.insertElements(this.circularList,1,3,7);
        assertEquals(Optional.empty(), this.circularList.next(this.strategyFactory.createEvenStrategy()));
    }

    @Test
    void testEmptyMultipleOfStrategy() {
        CircularListTestUtils.insertElements(this.circularList,1,3,7);
        assertEquals(Optional.empty(), this.circularList.next(this.strategyFactory.createMultipleOfStrategy(2)));
    }

    @Test
    void testEmptyEqualsStrategy() {
        CircularListTestUtils.insertElements(this.circularList,1,3,7);
        assertEquals(Optional.empty(), this.circularList.next(this.strategyFactory.createEqualsStrategy(8)));
    }

    @Test
    void testCircularityNextWithStrategy() {
        CircularListTestUtils.insertElements(this.circularList,1,2,3,5);
        this.circularList.next();
        this.circularList.next();
        assertEquals(2, this.circularList.next(this.strategyFactory.createEvenStrategy()).get());
    }

}
