package src.september;

import java.util.Arrays;

public class LC27 {
    public static void main(String[] agrs) {
        removeElement(new int[]{}, 1);
    }

    public static int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) count++;
            if (nums[i] > val) nums[i-count] = nums[i];
        }
        return Arrays.copyOfRange(nums,0,nums.length-count).length;
    }
}
