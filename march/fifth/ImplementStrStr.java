package LeetCoding.march.fifth;

/**
 * https://leetcode.com/problems/implement-strstr/description/
 */
public class ImplementStrStr {
    public static void main(String[] args) {
//        System.out.println(strStr("hello", "ll"));
//        System.out.println(strStr("aaab-", "b-"));
        System.out.println(strStr("1 1", " 1"));
    }

    private static int strStr(String haystack, String needle) {
        if ((haystack == null || needle == null)) {
            return -1;
        }
        if ((haystack.trim().length() == 0 && needle.trim().length() == 0) && haystack.length()>=needle.length()) {
            return 0;
        }
        if (haystack.contains(needle)) {
            for (int i = 0; i < haystack.length(); i++) {
                try {
                    CharSequence subSqu = haystack.subSequence(i, needle.length() + i);
                    if (subSqu.toString().equals(needle)) {
                        return i;
                    }
                } catch (Exception e){
                    return -1;
                }
            }
        }
        return -1;
    }
}
