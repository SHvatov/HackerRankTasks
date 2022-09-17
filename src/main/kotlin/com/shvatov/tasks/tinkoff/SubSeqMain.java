package com.shvatov.tasks.tinkoff;

import java.util.*;
import java.util.stream.Collectors;

public class SubSeqMain {
    private static long maxSequenceSum(final List<Long> initialSequence) {
        final List<List<Long>> subSequences = new ArrayList<>();
        for (final Long elem : initialSequence) {
            for (final List<Long> subSequence : subSequences) {
                if (subSequence.get(subSequence.size() - 1) < elem) {
                    subSequence.add(elem);
                }
            }

            subSequences.add(new ArrayList<>(Collections.singletonList(elem)));
        }

        return subSequences.stream()
            .mapToLong(it -> it.stream().reduce(0L, Long::sum))
            .max()
            .orElseGet(() -> 0);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final long sequenceLen = Long.parseLong(scanner.nextLine().trim());
        final List<Long> sequence = Arrays.stream(
            scanner
                .nextLine()
                .split(" ")
        ).mapToLong(it -> Long.parseLong(it.trim())).boxed().collect(Collectors.toList());

        assert sequence.size() == sequenceLen;
        System.out.println(maxSequenceSum(sequence));
    }
}
