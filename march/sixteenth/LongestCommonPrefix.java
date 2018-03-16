package LeetCoding.march.sixteenth;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"ca", "a"}));
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        String possiblePrefix = strs[0];
        for (String str : strs) {
            if (possiblePrefix.length() > str.length()) {
                possiblePrefix = str;
            }
        }

        int index = possiblePrefix.length();
        outter:
        while (index-- >= 0) {
            possiblePrefix = possiblePrefix.substring(0, index+1);
            for (String s : strs) {
                if (!s.startsWith(possiblePrefix)) {
                    continue outter;
                }
            }
            return possiblePrefix;
        }
        return possiblePrefix;
    }
}
