package LeetCoding.march.forteen;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 * I - 1
 * V - 5
 * X - 10
 * L - 50
 * C - 100
 * D - 500
 * M - 1000
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("CXI")); //111
        System.out.println(romanToInt("CMXCIX")); //999
        System.out.println(romanToInt("CDXCIX")); //499
        System.out.println(romanToInt("DCLXVI")); //666
        System.out.println(romanToInt("CCCLXXXV")); //385
    }

    private static int romanToInt(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        char chL = s.charAt(0);
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            char chR = s.charAt(i);
            int valL = hashMap.get(chL);
            int valR = hashMap.get(chR);
            if ((chL == 'C' || chL == 'X' || chL == 'I') && valL < valR) {
                result -= valL;
            } else {
                result += valL;
            }
            chL = chR;
        }
        result += (hashMap.get(s.charAt(s.length()-1)));
        return result;
    }
}
