package LeetCoding.march.twelvth;

import java.util.*;

/**
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
 */
public class OnebitAndTwobitCharacters {
    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[] {0}));
    }
    private static boolean isOneBitCharacter(int[] bits) {
        int temp = 0;
        while (temp < bits.length) {
            if (temp == bits.length - 1) {
                return true;
            }
            if (bits[temp] == 1) {
                temp += 2;
            } else {
                temp += 1;
            }
        }
        return false;
    }
}
