package lab01.tdd.model.strategy.factory;

import lab01.tdd.model.strategy.EqualsStrategy;
import lab01.tdd.model.strategy.MultipleOfStrategy;
import lab01.tdd.model.strategy.SelectStrategy;

public final class SelectStrategyFactoryImpl implements SelectStrategyFactory{
    @Override
    public SelectStrategy createEvenStrategy() {
        return new MultipleOfStrategy(2);
    }

    @Override
    public SelectStrategy createMultipleOfStrategy(final int divisor) {
        return new MultipleOfStrategy(divisor);
    }

    @Override
    public SelectStrategy createEqualsStrategy(final int number) {
        return new EqualsStrategy(number);
    }
}
