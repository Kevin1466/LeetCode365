package LeetCoding.march.twelvth;

import org.omg.CORBA.FREE_MEM;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

public class DegreeOfAnArray {
    public static void main(String[] args) {
        //System.out.println(findShortestSubArray(new int[] {1, 2, 2, 3, 1}));
        System.out.println(findShortestSubArray(new int[] {0}));
    }

    private static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int frequency = hashMap.get(nums[i]) == null ? 0 : hashMap.get(nums[i]);
            hashMap.put(nums[i], ++frequency);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        int frequency = Integer.MIN_VALUE;
        while (iterator.hasNext()) {
            int frequencyValue = iterator.next().getValue();
            if (frequency < frequencyValue) {
                frequency = frequencyValue;
            }
        }

        iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            int frequencyValue = iterator.next().getValue();
            if (frequencyValue < frequency) {
                iterator.remove();
            }
        }

        iterator = hashMap.entrySet().iterator();
        int result = Integer.MAX_VALUE;
        while (iterator.hasNext()) {
            Integer key = iterator.next().getKey();
            int value = hashMap.get(key);

            int[] indexs = new int[value];
            int c = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == key) {
                    indexs[c++] = j;
                }
            }
            //System.out.println("indexs == " + Arrays.toString(indexs));
            int span = indexs[value - 1] - indexs[0] + 1;
            if (result > span) {
                result = span;
            }
        }
        return result;
    }
}
