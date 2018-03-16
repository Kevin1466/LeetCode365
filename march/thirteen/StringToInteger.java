package LeetCoding.march.thirteen;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class StringToInteger {
    public static void main(String[] args) {

        System.out.println(myAtoi("-"));
        System.out.println(myAtoi("-159"));
        System.out.println(myAtoi("+159"));
        System.out.println(myAtoi("159"));
        System.out.println(myAtoi("-+159"));
        System.out.println(myAtoi("+-159"));
        System.out.println(myAtoi("+-15q9"));
        System.out.println(myAtoi("+-a159"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("      -11919730356x"));
        System.out.println(myAtoi("  -0012a42"));
//
        System.out.println(myAtoi("  +2147483647"));
        System.out.println(myAtoi("  +2147483648"));
        System.out.println(myAtoi("  -2147483648"));
        System.out.println(myAtoi("  -2147483649"));

        System.out.println(myAtoi("   -1123u3761867"));
        System.out.println(myAtoi("  -001242"));
        System.out.println(myAtoi("  -0012a42"));
    }

    private static int myAtoi(String str) {
        str = str.trim();
        int result = 0;
        boolean isPositive = true;
        if (str.length() <= 0) {
            return 0;
        }
        if (str.charAt(0) == '+') {
            isPositive = true;
            str = str.substring(1,str.length());
        } else if (str.charAt(0) == '-') {
            isPositive = false;
            str = str.substring(1,str.length());
        }

        int nonDigitPosition =  str.length();
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                nonDigitPosition = i;
                break;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            try {
                if (!Character.isDigit(ch)) {
                    break;
                }
                int pow = (int) Math.pow(10, nonDigitPosition-i-1);
                if (pow < 0) throw new Exception();

                result += (ch - '0') * pow;
                if (result < 0) throw new Exception();
            } catch (Exception e) {
                return isPositive ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
        }
        return isPositive ? result : -result;
    }
}
