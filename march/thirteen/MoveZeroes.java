package LeetCoding.march.thirteen;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[] {3,12,0,0,0,0,0});
    }

    private static void moveZeroes(int[] nums) {
        // find all 0's
        int countZeros = 0;
        for (int item : nums) {
            if (item == 0) {
                countZeros++;
            }
        }
        int indexZero = 0;
        while (indexZero < countZeros) {
            for (int i = 0; i < nums.length - indexZero; i++) {
                if (nums[i] == 0) {
                    for (int j = i; j < nums.length-1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    nums[nums.length - 1] = 0;
                    indexZero ++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
