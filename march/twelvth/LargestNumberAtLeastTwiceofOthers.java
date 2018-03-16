package LeetCoding.march.twelvth;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class LargestNumberAtLeastTwiceofOthers {
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[] {1,0}));
        //dominantIndex(new int[] {3,6,1,0});
    }

    private static int dominantIndex(int[] nums) {
        if(nums==null || nums.length < 2) return 0;
        int index = 0;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < nums.length - 1 - j; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                } else {
                    if (j == 0) index = i+1;
                }
            }
        }
        int diff = nums[nums.length-1] - 2*nums[nums.length-2];
        if (diff >= 0) {
            return index;
        }
        return -1;
    }
}
