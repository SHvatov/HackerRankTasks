package com.shvatov.hacker.rank.tinkoff;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BaguetteMain {
    private static int findBaguette(final int l,
                                    final int k,
                                    final int m) {
        // simple check
        if (l < k) {
            return -1;
        } else if (l == k) {
            return 1;
        }

        // a(i + 1) = k + i * m
        // i = (l - k) / m + 1
        if ((l - k) % m == 0) {
            return (l - k) / m + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        final List<Integer> parameters = Arrays.stream(
            new Scanner(System.in)
                .nextLine()
                .split(" ")
        ).mapToInt(it -> Integer.parseInt(it.trim())).boxed().collect(Collectors.toList());

        assert parameters.size() == 3;
        System.out.println(findBaguette(parameters.get(0), parameters.get(1), parameters.get(2)));
    }
}
