package september.seventh;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 */
public class NthDigit {
    public static void main(String[] args) {
        System.out.print(findNthDigit(15));
    }

    public static int findNthDigit(int n) {
        int number = 0;
        List<Character> characterList = new LinkedList<>();
        while (true) {
            number ++;
            for (Character ch : String.valueOf(number).toCharArray()) {
                if (characterList.size() < n) {
                    characterList.add(ch);
                } else {
                    return ((LinkedList<Character>) characterList).getLast() - '0';
                }
            }
        }
    }
}
