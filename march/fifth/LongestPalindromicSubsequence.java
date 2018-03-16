package LeetCoding.march.fifth;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("aabaa"));
    }

    //bbbabc
    private static int longestPalindromeSubseq(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int maxRepeat = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int count = hashMap.get(ch) == null ? 0:hashMap.get(ch);
            hashMap.put(ch, ++count);
            if (maxRepeat < count) maxRepeat = count;
        }
        return maxRepeat;
    }
}
