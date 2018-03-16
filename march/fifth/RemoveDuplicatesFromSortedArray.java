package LeetCoding.march.fifth;

import org.omg.PortableInterceptor.INACTIVE;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {-1,0,0,0,0,3,3}));
    }
    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int currentNum = nums[0];
        int repeatCount = 0;
        int splitpor = Integer.MAX_VALUE;

        for (int i = Integer.MIN_VALUE ; i <= Integer.MAX_VALUE; i++) {
            if (i > nums[nums.length-1] || i < nums[0]) {
                splitpor = i;
                break;
            }

            boolean found = false;
            for (int j = 0; j < nums.length && !found; j++) {
                if (i == nums[j]) {
                    break;
                } else if (j == nums.length-1) {
                    splitpor = i;
                    found = true;
                }
            }

        }
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            if (currentNum == nums[i]) {
                repeatCount++;
                nums[i] = splitpor;
            }
            currentNum = temp;
        }


        int dul = 0;
        for (int i = 0; i < nums.length - dul && dul<repeatCount; i++) {
            if (nums[i] == splitpor) {
                for (int j = i; j < nums.length-1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - dul - 1] = 0;
                dul++;
                i = 0;
            }
        }

        //System.out.println(Arrays.toString(nums));
        return nums.length - repeatCount;
    }
}
