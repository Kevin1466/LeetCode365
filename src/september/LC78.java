package src.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC78 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res.add(new ArrayList<>());
                res.add(Arrays.asList(nums[i]));
                //dfs(res);
            } else {

            }
        }
        return null;
    }

    private static void helper(int[] nums, int position, List<List<Integer>> subSet) {

    }
}
