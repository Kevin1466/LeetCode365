package LeetCoding;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

    }

    public static int characterReplacement(String s, int k) {
        Set<Character> charSet = new HashSet<>();
        for (Character ch : s.toCharArray()) {
            charSet.add(ch);
        }

        for (Character ch : charSet) {

        }

        int subStrLengthMax = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                subStrLengthMax++;
            }

        }
        return 0;
    }
}
