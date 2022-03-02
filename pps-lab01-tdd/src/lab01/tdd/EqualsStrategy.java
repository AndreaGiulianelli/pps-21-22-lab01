package lab01.tdd;

public class EqualsStrategy implements SelectStrategy {
    private final int number;

    public EqualsStrategy(final int number) {
        this.number = number;
    }

    @Override
    public boolean apply(int element) {
        return this.number == element;
    }
}
