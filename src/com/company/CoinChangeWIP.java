package com.company;

public class CoinChangeWIP {
    public static void main(String[] args) {
        CoinChangeWIP coinChange = new CoinChangeWIP();
        int[] coins = new int[]{1,2,5};
        int result = coinChange.coinChange(coins, 11);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return coinChange(coins, amount, memo);
    }

    public int coinChange(int[] coins, int amount, int[] memo) {
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }
        if (amount == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (amount - coin < 0)
                continue;

            int minNumberOfCoins = coinChange(coins, amount - coin, memo);
            if (minNumberOfCoins >= 0) {
                res = Math.min(res, minNumberOfCoins + 1);
            }
        }

        memo[amount] = res != Integer.MAX_VALUE ? res : -1;
        return memo[amount];
    }
}
