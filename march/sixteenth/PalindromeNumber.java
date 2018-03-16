package LeetCoding.march.sixteenth;

/**
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-999));
        System.out.println(isPalindrome(12343210));
        System.out.println(isPalindrome(1234321));
        System.out.println(isPalindrome(12344321));
    }

    private static boolean isPalindrome(int x) {
        String sx = String.valueOf(x);
        for (int i = 0, j = sx.length()-1; i <= j; i++, j--) {
            if (sx.charAt(i) != sx.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
