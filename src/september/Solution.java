package src.september;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        solution(new int[] {1,0,0,1,1,1});
    }

    public static int[] solution(int[] A) {
        int sum = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            sum += A[i]*Math.pow(-2, i);
        }
        int target = (int) Math.ceil(sum/2);
        if (target % 2 != 0) {
            res.add(1);
        }
        int[] dp = new int[A.length];
        int index = 1, tempSum = 0;
        while (true) {

            index++;
        }
    }
}
