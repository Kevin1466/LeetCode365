package LeetCoding.march.sixteenth;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
    private static final char MIDDLE_LEFT  = '[';
    public static void main(String[] args) {
        System.out.println(isValid("()("));
    }

    private static boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 != 0) return false;
        for (int i = 0; i < s.length()-1; i += 2) {
            char bracketAtI = s.charAt(i);
            char bracketFollowI = s.charAt(i+1);
            if (bracketAtI == '(' && bracketFollowI == ')'
                    || bracketAtI == '[' && bracketFollowI == ']'
                        || bracketAtI == '{' && bracketFollowI == '}') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
