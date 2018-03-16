package LeetCoding.march.twelvth;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/perfect-number/description/
 */
public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(0));
    }

    private static boolean checkPerfectNumber(int num) {
        if (num <= 0) return false;
        Set<Integer> hashSet = new HashSet<>(num);
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                hashSet.add(i);
                hashSet.add(num/i);
            }
        }
        hashSet.remove(num);
        int sum = 0;
        for (int each : hashSet) {
            sum += each;
            System.out.println(each);
        }
        return sum == num;
    }
}
