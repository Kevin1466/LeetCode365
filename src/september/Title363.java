package src.september;

import java.util.*;

// TODO: 18-10-12 unfinished, should be review 
public class Title363 {
    public static void main(String[] args) {
        System.out.println(maxSumSubmatrix(new int[][] {
                {1,4,2,3,0},
                {6,1,3,-2,1},
                {5,8,0,9,-1}
        }, 30));
    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] sum = matrix;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i][j] += sum[i-1][j];
            }
        }
        int ret = 1<<31;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] number = new int[m];
                TreeSet<Integer> set = new TreeSet<>();
                for (int l = 0; l < m; l++) {
                    number[l] = sum[j][l] - (i==0 ? 0:sum[i-1][l]);
                }
                for (int l = 1; l < m; l++) {
                    number[l] += number[l-1];
                }
                set.add(0);
                for (int num : number) {
                    Integer res = set.lower(num-k);
                    if (res == null) res = 0;
                    ret = Math.max(ret, num-res);
                    set.add(num);
                }
            }
        }
        return ret;
    }
}
