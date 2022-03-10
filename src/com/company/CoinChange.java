package com.company;

import java.util.*;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = new int[]{186,419,83,408};
        int result = coinChange.coinChange(coins, 6249);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Integer[] memo = new Integer[amount + 1];
        int numberOfCoinsNeeded = getNumberOfCoinsNeeded(coins, amount, memo);
        return numberOfCoinsNeeded < 1 ? -1 : numberOfCoinsNeeded;
    }

    private int getNumberOfCoinsNeeded(int[] coins, int amountRemaining, Integer[] memo) {
        if (amountRemaining < 0) {
            return -1;
        }

        if (amountRemaining == 0) { // count it!
            return 0;
        }

        if (memo[amountRemaining] != null) {
            return memo[amountRemaining];
        }

        Integer[] counts = new Integer[coins.length];
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            if (amountRemaining - coin >= 0) {
                int numberOfCoinsNeeded = getNumberOfCoinsNeeded(coins, amountRemaining - coin, memo);
                if(numberOfCoinsNeeded != -1) {
                    counts[i] = numberOfCoinsNeeded + 1;
                }
            }
        }

        OptionalInt minimumOptional = Arrays
                .stream(counts)
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .min();

        if (minimumOptional.isPresent() && minimumOptional.getAsInt() != -1) {
            // if this is a minimum path, it should be stored: memoize it
            memo[amountRemaining] = memo[amountRemaining] != null ? Math.min(memo[amountRemaining], minimumOptional.getAsInt()) : minimumOptional.getAsInt();
            return memo[amountRemaining];
        }

        return -1;
    }
}
