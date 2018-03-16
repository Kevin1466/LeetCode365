package LeetCoding.march.thirteen;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/description/
 */
public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6})));
    }

    private static int[] plusOne(int[] digits) {
        String number = "";
        for (int dgt : digits) {
            number += dgt;
        }

        BigDecimal bigDecimal = new BigDecimal(number);
        bigDecimal = bigDecimal.add(new BigDecimal(1));
        String numberPlusedOne = bigDecimal.toString();
        int[] digitsPlusedOne = new int[numberPlusedOne.length()];

        for (int i = 0; i < digitsPlusedOne.length; i++) {
            digitsPlusedOne[i] = numberPlusedOne.charAt(i) - '0';
        }
        return digitsPlusedOne;
    }
}
