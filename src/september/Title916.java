package src.september;

import java.util.*;

public class Title916 {
    public static void main(String[] args) {

    }

    public static List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>(A.length);
        StringBuffer buffer = new StringBuffer();
        Set<Character> bLetterSet = new HashSet<>();
        for (String sb : B) {
            for (char c : sb.toCharArray()) {
                bLetterSet.add(c);
            }
        }
        for (char c : bLetterSet) {
            buffer.append(c);
        }
        for (String str : A) {
            Set<Character> characters = new HashSet<>();


            boolean bool = true;

            result.add(str);
        }
        return null;
    }
}
