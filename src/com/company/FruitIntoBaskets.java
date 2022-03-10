package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        int[] fruits = {1, 2, 3, 2, 2};
        int result = fruitIntoBaskets.totalFruit(fruits);
        System.out.print(result);
    }

    public int totalFruit(int[] fruits) {
        int aPointer = 0;
        int bPointer = 0;
        int maxFruitsHarvested = 0;

        Map<Integer, Integer> fruitTypeToLastIndex = new HashMap<>();

        while (bPointer < fruits.length) {
            int nextFruit = fruits[bPointer];

            if (fruitTypeToLastIndex.size() <= 2) {
                fruitTypeToLastIndex.put(nextFruit, bPointer++);
            }

            if (fruitTypeToLastIndex.size() > 2) {
                Integer maxIndexOfFruitToDrop = fruitTypeToLastIndex.values()
                        .stream()
                        .min(Comparator.comparingInt(a -> a))
                        .get();

                aPointer = maxIndexOfFruitToDrop + 1; // move the "left side" of the sliding window forward to 1 index
                // past the location of the third type of fruit: the one that's about to be dropped

                // drop 3rd fruit type from tracking
                fruitTypeToLastIndex.remove(fruits[maxIndexOfFruitToDrop]);
            }

            // there's one fruit at each index in the array - so distance between the 2 pointers gives what we want
            maxFruitsHarvested = Math.max(maxFruitsHarvested, bPointer - aPointer);
        }

        return maxFruitsHarvested;
    }
}
