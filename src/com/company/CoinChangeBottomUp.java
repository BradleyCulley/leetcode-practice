package com.company;

public class CoinChangeBottomUp {
    public static void main(String[] args) {
        CoinChangeBottomUp coinChange = new CoinChangeBottomUp();
        int[] coins = new int[]{3};
        int result = coinChange.coinChange(coins, 3);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];

        for (int currentAmountToSpend = 1; currentAmountToSpend < memo.length; currentAmountToSpend++) {
            int minCoinsForThisAmount = Integer.MAX_VALUE;

            for (int coin: coins) {
                if (currentAmountToSpend - coin == 0) {
                    minCoinsForThisAmount = 1;
                    break; // no need to look further
                }

                if (currentAmountToSpend - coin > -1 &&
                    memo[currentAmountToSpend - coin] != -1) { // if there's a memo entry for what we get when we subtract off
                    // this one coin, then say it takes: the number (of coins) at that memo entry,
                    // plus 1 (to count this coin)
                    minCoinsForThisAmount = Math.min(minCoinsForThisAmount, 1 + memo[currentAmountToSpend - coin]); // but only count
                    // it if it's a smaller # of steps than we'd get using a different coin for this same "remaining amount"
                }
            }

            // memoize only the winner of the smallest number of steps for this "remaining amount"
            memo[currentAmountToSpend] = minCoinsForThisAmount == Integer.MAX_VALUE ? -1 : minCoinsForThisAmount;
        }

        return memo[amount]; // return the value at the end of the array: the value we've been building up to
    }
}
