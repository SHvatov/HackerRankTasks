package com.shvatov.hacker.rank.yandex;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class EvenIteratorStream implements Iterator<Integer> {
    private final List<Integer> collection;

    private Integer currenEvenElementIndex = null;

    EvenIteratorStream(final List<Integer> collection) {
        this.collection = collection;
        this.currenEvenElementIndex = findNextEvenElementIndex(currenEvenElementIndex);
    }

    @Override
    public boolean hasNext() {
        return currenEvenElementIndex != null;
    }

    @Override
    public Integer next() {
        final var element = collection.get(currenEvenElementIndex);
        currenEvenElementIndex = findNextEvenElementIndex(currenEvenElementIndex);
        return element;
    }

    private Integer findNextEvenElementIndex(final Integer current) {
        final var start = Objects.isNull(current) ? 0 : current + 1;
        for (int i = start; i < collection.size(); i++) {
            final var element = collection.get(i);
            if (Objects.isNull(element)) {
                continue;
            }

            if (element % 2 == 0) {
                return i;
            }
        }
        return null;
    }
}
