package LeetCoding.march.sixteenth;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class ReverseInteger {
    public static void main(String[] args) {
//        reverse(+103);
//        reverse(+0);
//        reverse(-0);
//        reverse(0);
//        reverse(000);
        reverse(Integer.MAX_VALUE);
        reverse(Integer.MIN_VALUE-1);
    }

    private static int reverse(int x) {

        System.out.println(Integer.MAX_VALUE);
        StringBuilder sxBuilder = new StringBuilder(String.valueOf(x));
        //System.out.println(sxBuilder.toString());
        boolean isPositive = true;
        if (sxBuilder.charAt(0) == '-') {
            isPositive = false;
            sxBuilder.deleteCharAt(0);
        }

        sxBuilder.reverse();
        int result;
        try {
            result = Integer.parseInt(sxBuilder.toString());
        } catch (Exception e) {
            result = 0;
        }
        result = isPositive ? result : -result;
        return result;
    }
}
