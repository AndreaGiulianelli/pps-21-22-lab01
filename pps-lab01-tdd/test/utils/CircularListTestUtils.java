package utils;

import lab01.tdd.model.CircularList;

/**
 * Utils for all the tests
 */
public final class CircularListTestUtils {
    private CircularListTestUtils() {}

    public static void insertElements(final CircularList circularList, final Integer... elements) {
        for(int element : elements) {
            circularList.add(element);
        }
    }
}
