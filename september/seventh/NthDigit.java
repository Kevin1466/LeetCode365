package september.seventh;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 */
public class NthDigit {
    public static void main(String[] args) {
        System.out.print(findNthDigit(11));
    }

    public static int findNthDigit(int n) {
        /**
         * 1-9，一次贡献1个digit，一共9个
         * 10-99，一次贡献2个digit，一共90*2个
         * 100-999，一次贡献3个digit，一共900*3个
         * 1000-9999, n = 1002
         *
         * 若n==99,
         */
        int digit = 0;
        int count = 0;
        while (true) {
            int digits = (int) (9 * Math.pow(10, digit) * (++digit)); // 9, 180, 270
            if (count + digits > n) {
                int d = n - count; // 再数4个digit
                int i = d / digit; // 4个digit就是i个数
                int base = (int) Math.pow(10, digit-1);
                int y = d - (i * digit); // 在第i个数字上，取第y个digit
                return String.valueOf(base + i).charAt(y-1) - '0';
            } else {
                count += digits;
            }
        }

       /* int number = 0;
        String strNumber;
        int charLength = 0;
        while (true) {
            number ++;
            strNumber = String.valueOf(number);
            int numLen = strNumber.length();
            if (charLength + numLen < n) {
                charLength += numLen;
            } else {
                return strNumber.charAt(n-charLength-1) - '0';
            }
        }*/
    }
}
