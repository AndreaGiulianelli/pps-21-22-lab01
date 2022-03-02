package lab01.tdd.model.strategy.factory;

import lab01.tdd.model.strategy.SelectStrategy;

/**
 * Abstract Factory for SelectStrategy type
 */
public interface SelectStrategyFactory {
    /**
     * Creates the even strategy
     * @return an implementation the of even strategy
     */
    SelectStrategy createEvenStrategy();
    /**
     * Creates the multiple of strategy
     * @return an implementation of the multiple strategy
     */
    SelectStrategy createMultipleOfStrategy(int divisor);
    /**
     * Creates the equals strategy
     * @return an implementation of equals strategy
     */
    SelectStrategy createEqualsStrategy(int number);
}
