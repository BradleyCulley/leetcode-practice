package com.company;

import java.util.Stack;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int result = reverseInteger.reverse(123);
        System.out.println(result);
    }

    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1; // make it positive for during the reversing process,
            // then switch it back to negative afterward
        }

        Stack<Integer> digits = new Stack<>();

        while (x > 0) {
            int currentDigit = x % 10; // obtain ending digit
            x /= 10; // delete ending digit

            digits.push(currentDigit);
        }

        int reversed = 0;
        int currentPowerOf10 = 0;

        while (!digits.isEmpty()) {
            int currentDigit = digits.pop();

            reversed += currentDigit * Math.pow(10, currentPowerOf10++);
        }

        return isNegative ? reversed * -1 : reversed;
    }
}
