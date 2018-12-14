package src.september;

import java.util.ArrayList;
import java.util.List;

public class Title763 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("q").size());
    }

    public static List<Integer> partitionLabels(String S) {
        int sLength = S.length();
        List<Character> tobeCheckedList = new ArrayList<>();
        List<Character> restList = new ArrayList<>();
        List<Character> entireList = new ArrayList<>(sLength);
        for (char ch : S.toCharArray()) {
            entireList.add(ch);
        }
        List<Character> assistantList = new ArrayList<>(sLength);
        List<Integer> result = new ArrayList<>();
        int step = 0;
        for (int start = 0; start < sLength; start += step) {
            int end = start;
            while (end < entireList.size()) {
                tobeCheckedList.clear();
                tobeCheckedList.addAll(entireList.subList(start, end+1));
                restList.clear();
                restList.addAll(entireList.subList(end + 1, entireList.size()));
                assistantList.clear();
                assistantList.addAll(tobeCheckedList);
                assistantList.retainAll(restList);
                if (assistantList.size() > 0) {
                    end++;
                } else {
                    List<Character> partitionList = entireList.subList(start, end + 1);
                    step = partitionList.size();
                    result.add(partitionList.size());
                    break;
                }
            }
        }
        return result;

        /*for (int i = 0; i < result.size(); i++) {
            List<Character> characters = result.get(i);
            System.out.print("[");
            for (char ch : characters) {
                System.out.print(ch + " ");
            }
            System.out.print("]");
            System.out.println();
        }*/
    }
}
