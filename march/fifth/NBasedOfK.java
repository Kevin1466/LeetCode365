package LeetCoding.march.fifth;

import java.util.Arrays;

public class NBasedOfK {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(doIntegerBasedRounding(new int []{1,2,4,5,6,7,8,9,9},5)));
        System.out.println(Arrays.toString(doIntegerBasedRounding(new int []{1, 2, 3, 4, 5},2)));
        System.out.println(Arrays.toString(doIntegerBasedRounding(new int []{1, 2, 3, 4, 5},3)));
        System.out.println(Arrays.toString(doIntegerBasedRounding(new int []{1, 2, 3, 4, 5},-3)));
        System.out.println(Arrays.toString(doIntegerBasedRounding(new int []{-1, -2, -3, -4, -5},3)));
        System.out.println(Arrays.toString(doIntegerBasedRounding(new int []{-18, 1, 2, 3, 4, 5},4)));
        System.out.println(Arrays.toString(doIntegerBasedRounding(new int []{1, 2, 3, 4, 5},5)));
        System.out.println(Arrays.toString(doIntegerBasedRounding(new int []{1, 2, 3, 4, 5},100)));
    }

    private static long[] doIntegerBasedRounding(int[] ints, int i) {
        long[] result = new long[ints.length];
        for (int k = 0; k < ints.length; k++) {
            int item = ints[k];
            if (i == 0) {
                result[k] = 0;
                continue;
            } else if (i < 0) {
                i = -i;
            }
            if (item < 0) {
                result[k] = item;
                continue;
            }
            int multi = 0;
            int right = 0;
            while (right < item) {
                right = i*(++multi);
            }
            int left = i*(multi-1);

            if (right + left <= 2*item) {
                result[k] = right;
            } else {
                result[k] = left;
            }
        }
        return result;
    }
}
