package src.september;

import java.util.*;

public class LC784 {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation2("a1b1"));
    }

    private static List<String> letterCasePermutation2(String ss) {
        List<String> result = new ArrayList<>();
        helper(ss, result, 0);
        return result;
    }

    private static void helper(String s, List<String> res, int pos) {
        if (pos == s.length()) {
            res.add(s);
            return;
        }

        if (Character.isDigit(s.charAt(pos))) {
            helper(s, res, pos+1);
        } else {
            StringBuffer temp = new StringBuffer(s);

            temp.setCharAt(pos, Character.toUpperCase(s.charAt(pos)));
            helper(temp.toString(), res, pos+1);

            temp.setCharAt(pos, Character.toLowerCase(s.charAt(pos)));
            helper(temp.toString(), res, pos+1);
        }
    }

    public static List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        queue.add(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                StringBuffer temp = new StringBuffer(queue.poll());
                temp.setCharAt(i, Character.toUpperCase(S.charAt(i)));
                queue.offer(temp.toString());
                temp.setCharAt(i, Character.toLowerCase(S.charAt(i)));
                queue.offer(temp.toString());
            }
        }
        return new LinkedList<>(queue);
    }
}
