package lab01.tdd;

import lab01.tdd.SelectStrategy;

public class MultipleOfStrategy implements SelectStrategy {
    private final int divisor;

    public MultipleOfStrategy(final int divisor) {
        this.divisor = divisor;
    }
    @Override
    public boolean apply(int element) {
        return element % divisor == 0;
    }
}
