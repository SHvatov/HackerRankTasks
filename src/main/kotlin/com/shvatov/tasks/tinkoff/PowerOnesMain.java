package com.shvatov.tasks.tinkoff;

import java.util.Scanner;

public class PowerOnesMain {
    private static int calculatePower(final String number) {
        int power = 0;
        boolean isTrailingOnes = true;
        for (int index = number.length() - 1; index >= 0; index--) {
            if (!isTrailingOnes && number.charAt(index) == '1') {
                power++;
            } else if (isTrailingOnes && number.charAt(index) != '1') {
                isTrailingOnes = false;
            }
        }
        return power;
    }

    public static void main(String[] args) {
        final String number =  new Scanner(System.in).nextLine();
        System.out.println(calculatePower(number));
    }
}
