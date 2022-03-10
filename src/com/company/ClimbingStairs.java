package com.company;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int result = climbingStairs.climbStairs(3);
        System.out.println(result);
    }

    private Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }

        if(memo.containsKey(n)) {
            return memo.get(n);
        }

        if(n > 1) {
            int stepsForCurrentN = climbStairs(n - 2) +
                    climbStairs(n - 1);
            if(!memo.containsKey(n)) {
                memo.put(n, stepsForCurrentN);
            }
            return stepsForCurrentN;
        }

        int stepsForCurrentN = climbStairs(n - 1);
        if(!memo.containsKey(n)) {
            memo.put(n, stepsForCurrentN);
        }
        return stepsForCurrentN;
    }
}
