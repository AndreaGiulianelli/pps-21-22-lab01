package lab01.tdd.model;

import lab01.tdd.model.strategy.SelectStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BasicCircularList implements CircularList{
    private final List<Integer> elements;
    private int currentIndex;

    public BasicCircularList() {
        this.elements = new ArrayList<>();
        this.currentIndex = 0;
    }

    @Override
    public void add(int element) {
        this.elements.add(element);
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> current = Optional.empty();
        if (!this.isEmpty()) {
            current = Optional.of(this.elements.get(this.currentIndex));
            this.increaseCurrentIndex();
        }
        return current;
    }

    @Override
    public Optional<Integer> previous() {
        Optional<Integer> current = Optional.empty();
        if (!this.isEmpty()) {
            this.decrementCurrentIndex();
            current = Optional.of(this.elements.get(this.currentIndex));
        }
        return current;
    }

    @Override
    public void reset() {
        this.currentIndex = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        final int startIndex = this.currentIndex;
        Optional<Integer> element;
        do {
            element = this.next().filter(strategy::apply);
        } while (this.currentIndex != startIndex && element.isEmpty());

        return element;
    }

    private void increaseCurrentIndex() {
        if (this.currentIndex == this.elements.size() - 1) {
            this.currentIndex = 0;
        } else {
            this.currentIndex++;
        }
    }

    private void decrementCurrentIndex() {
        if(this.currentIndex == 0) {
            this.currentIndex = this.elements.size() - 1;
        } else {
            this.currentIndex--;
        }
    }
}
