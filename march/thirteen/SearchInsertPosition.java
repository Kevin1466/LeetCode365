package LeetCoding.march.thirteen;

public class SearchInsertPosition {
    public static void main(String[] args) {
        //System.out.println(searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(searchInsert(new int[] {1,3,5,6}, 6));
        System.out.println(searchInsert(new int[] {1,3,5,6}, 0));

        System.out.println(searchInsert(new int[] {1,3}, 3));
        System.out.println(searchInsert(new int[] {1}, 2));
    }

    private static int searchInsert(int[] nums, int target) {
        int insertPosition = 0;
        for (int i = 0; i < nums.length; i++) {

            if (target > nums[i]) {
                insertPosition ++;
            } else {
                break;
            }
        }
        return insertPosition;
    }
}
