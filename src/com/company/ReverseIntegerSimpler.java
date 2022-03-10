package com.company;

public class ReverseIntegerSimpler {
    public static void main(String[] args) {
        ReverseIntegerSimpler reverseInteger = new ReverseIntegerSimpler();
        int result = reverseInteger.reverse(123);
        System.out.println(result);
    }

    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int currentDigit = x % 10; // obtain ending digit
            x /= 10; // delete ending digit

            if (
                    (reversed > Integer.MAX_VALUE / 10) ||
                            (
                                    (reversed == Integer.MAX_VALUE / 10) &&
                                            currentDigit > 7
                            )
            ) {
                return 0;
            }

            if (
                    (reversed < Integer.MIN_VALUE / 10) ||
                            (
                                    (reversed == Integer.MIN_VALUE / 10) &&
                                            currentDigit < -8
                            )
            ) {
                return 0;
            }


            reversed = reversed * 10 + currentDigit;
        }

        return reversed;
    }
}
