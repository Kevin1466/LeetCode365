package LeetCoding.march.twelvth;

public class FindPivotIndex {
    public static void main(String[] args) {
        //System.out.println(pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
        //System.out.println(pivotIndex(new int[] {1, 2, 3}));
        System.out.println(pivotIndex(new int[] {-1,-1,0,0,-1,-1}));
        //System.out.println(pivotIndex(new int[] {1,1}));
    }

    private static int pivotIndex(int[] nums) {
        int index = -1;
        if (nums.length == 0) {
            index = -1;
        } else if (nums.length == 1){
            index = 0;
        } else if (nums.length == 2){
            if (nums[0] == 0 && nums[1] == 0) {
                index = 0;
            } else if (nums[0] == 0) {
                index = 1;
            } else if (nums[1] == 0) {
                index = 0;
            }
        } else {
            int sumLeft = 0;
            int sumAll = 0;
            for (int i = 0; i < nums.length; i++) {
                sumAll += nums[i];
            }
            for (int j = 0; j < nums.length; j++) {
                if (j==0) {
                    sumLeft = 0;
                } else {
                    sumLeft += nums[j - 1];
                }
                if (sumLeft == sumAll - sumLeft - nums[j]) {
                    index = j;
                    break;
                }
            }
        }
        return index;
    }
}
