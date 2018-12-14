package src.september.study;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[20];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        nums[random.nextInt(20)] = nums[random.nextInt(20)];
        System.out.print(Arrays.toString(nums));

        for (int i = 1; i <= 20; i++) {

        }
    }
}
