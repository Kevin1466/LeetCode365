package src.september;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Title84 {
    public static void main(String[] args) {

    }

    public static int largestRectangleArea(int[] heights) {
        List<Integer> Heights = new ArrayList<>();
        for (int h : heights) {
            Heights.add(h);
        }
        for (int height : heights) {
            int maxArea = 0;

            for (int i = heights.length-1; i >= 0; i--) {
                Collections.min(Heights);
            }
        }

        return 0;
    }
}
