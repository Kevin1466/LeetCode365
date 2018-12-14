package src.september;

public class LC55 {
    public static void main(String[] args) {
        System.out.print(canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }

    /**
     * greedy
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int curr = 0, currJump = nums[0], max = Integer.MIN_VALUE;
        if (currJump >= nums.length - 1) {
            return true;
        }
        while (true) {
            for (int i = curr; i <= currJump; i++) {
                max = Math.max(max, nums[i] + i);
            }
            if (max >= nums.length - 1) {
                return true;
            } else if (max == currJump) {
                return false;
            } else {
                curr = currJump;
                currJump = max;
            }
        }
    }
}
