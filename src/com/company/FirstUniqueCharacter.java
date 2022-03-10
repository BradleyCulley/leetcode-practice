package com.company;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        int result = firstUniqueCharacter.firstUniqChar("eleetcode");
        System.out.println(result);
    }

    public int firstUniqChar(String s) {
        int[] letterCounts = new int[26];

        char[] chars = s.toCharArray();

        for (char character : chars) {
            int letterIndexInAlphabet = character - 'a';

            letterCounts[letterIndexInAlphabet]++;
        }

        for (int i = 0; i < chars.length; i++) {
            int letterIndexInAlphabet = chars[i] - 'a';

            if (letterCounts[letterIndexInAlphabet] == 1) {
                return i;
            }
        }

        return -1;
    }
}
