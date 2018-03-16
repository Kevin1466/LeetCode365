package LeetCoding.march.thirteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 */
public class PascalTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
        System.out.println(getRow(5));
        System.out.println(getRow(6));
    }

    private static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        } else if (rowIndex == 1) {
            return Arrays.asList(1,1);
        } else {
            List<Integer> lastList = getRow(rowIndex-1);
            List<Integer> thisList = new ArrayList<>();
            for (int i = 0; i < Math.ceil((rowIndex + 1)*0.5); i++) {
                if (i == 0) {
                    thisList.add(1);
                } else {
                    int a = lastList.get(i-1) + lastList.get(i);
                    thisList.add(a);
                }
            }
            List<Integer> temp = new ArrayList<>(thisList);
            Collections.reverse(temp);
            if (rowIndex % 2 == 0) {
                temp.remove(0);
            }
            thisList.addAll(temp);
            return thisList;
        }
    }
}
