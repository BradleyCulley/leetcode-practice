package com.company;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        SumOfTwoNumbers sumOfTwoNumbers = new SumOfTwoNumbers();
        int sum = sumOfTwoNumbers.getSum(9, 11);
        System.out.println(sum);
    }

    /*
        Example: 3 + 5:

            4 2 1
            -----
            round 1:
            0 1 1
            1 0 1
            ----->
^           1 1 0
& >> 1    0 0 1 0   (because it's 0 0 1 >> 1)

            round 2:
            1 1 0
            0 1 0
          ------->
^           1 0 0
& >> 1    0 1 0 0   (because it's 0 1 0 >> 1)

            round 3:
            1 0 0
            1 0 0
            ------->
^           0 0 0
& >> 1    1 0 0 0   (because it's 1 0 0 >> 1)

            round 4:
           0 0 0 0
           1 0 0 0
           ------->
^          1 0 0 0
& >> 1     0 0 0 0   (because it's 0 0 0 0 >> 1)

        now the result of & >> 1 is 0!, so we're done and can return the result of the xor operation,
        which is: 1 0 0 0. 1 0 0 0 in base-2 notation is 8 in base-10 notation, which is the correct result of 3 + 5.
     */
    public int getSum(int a, int b) {
        int xor = a ^ b; // new a
        int andShifted = (a & b) << 1; // new b

        // loop until there isn't any carry from adding 1 in both numbers
        while (andShifted != 0) {
            int xorBefore = xor;
            xor = xor ^ andShifted;  // new a
            andShifted = (xorBefore & andShifted) << 1;  // new b
        }

        return xor;
    }
}
