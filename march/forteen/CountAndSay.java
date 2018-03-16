package LeetCoding.march.forteen;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-and-say/hints/
 */
public class CountAndSay {
    public static void main(String[] args) {
//        System.out.println(countAndSay(1));
//        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }

    private static String countAndSay(int n) {
        if (n == 1) return "1";
        else if (n == 2) return "11";
        else {
            String temp = countAndSay(n-1);
            List<Integer> count = new ArrayList<>();
            List<Integer> say = new ArrayList<>();
            int repeat = 1;
            for (int i = 0; i < temp.length()-1; i++) {
                if (temp.charAt(i) == temp.charAt(i+1)) {
                    repeat += 1;
                } else {
                    count.add(repeat);
                    say.add(temp.charAt(i) - '0');
                    repeat = 1;
                }
            }
            count.add(repeat);
            say.add(temp.charAt(temp.length()-1)-'0');
            String result = "";
            for (int i = 0; i < say.size(); i++) {
                result += count.get(i) +""+ say.get(i);
            }
            return result;
        }
    }
}
