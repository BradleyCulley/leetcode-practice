package com.company;

public class CoinChangeTopDown {
    public static void main(String[] args) {
        CoinChangeTopDown coinChange = new CoinChangeTopDown();
        int[] coins = new int[]{1,2,5};
        int result = coinChange.coinChange(coins, 11);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return coinChange(coins, amount, memo, 0);
    }

    public int coinChange(int[] coins, int amountRemaining, int[] memo, int numberOfCoins) {
        if (amountRemaining < 0) {
            return -1;
        }
        if (memo[amountRemaining] != 0) {
            return memo[amountRemaining];
        }
        if (amountRemaining == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (amountRemaining - coin >= 0) {
                int minNumberOfCoins = coinChange(coins, amountRemaining - coin, memo, numberOfCoins);
                if (minNumberOfCoins >= 0) {
                    res = Math.min(res, minNumberOfCoins + 1);
                }
            }
        }

        memo[amountRemaining] = res != Integer.MAX_VALUE ? res : -1;
        return memo[amountRemaining];
    }
}
