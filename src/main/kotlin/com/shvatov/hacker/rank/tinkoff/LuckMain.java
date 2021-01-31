package com.shvatov.hacker.rank.tinkoff;

import java.util.*;
import java.util.stream.Collectors;

public class LuckMain {
    private static int calculateMaximumLuck(final List<Integer> luckPoints) {
        assert (luckPoints.size() == 4);

        final Set<Integer> indices = new HashSet<>(Arrays.asList(1, 2, 3));
        int maximum = Integer.MIN_VALUE;
        for (int i = 1; i < luckPoints.size(); i++) {
            final int currentIndex = i;
            final int otherPairLuck = indices.stream()
                .filter(it -> it != currentIndex)
                .reduce(1, (acc, it) -> acc *= luckPoints.get(it));
            final int currentLuck = luckPoints.get(0) * luckPoints.get(i) + otherPairLuck;
            if (currentLuck > maximum) {
                maximum = currentLuck;
            }
        }
        return maximum;
    }

    public static void main(String[] args) {
        final List<Integer> luckPoints = Arrays.stream(
            new Scanner(System.in)
                .nextLine()
                .split(" ")
        ).mapToInt(it -> Integer.parseInt(it.trim())).boxed().collect(Collectors.toList());
        System.out.println(calculateMaximumLuck(luckPoints));
    }
}
