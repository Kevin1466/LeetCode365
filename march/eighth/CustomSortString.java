package LeetCoding.march.eighth;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

public class CustomSortString {

	public static void main(String[] args) {
		System.out.print(customSortString("kqep","apekeqm"));
	}
	
    public static String customSortString(String S, String T) {
    	StringBuffer ss = new StringBuffer();
    	Map<Character, Integer> hashMap = new HashMap<>();
    	int sequence = 0;
		for (char ch: S.toCharArray()) {
			hashMap.put(ch, sequence++);
		}

		List<Character> ll = new ArrayList<>();
		for (char c: T.toCharArray()) {
			ll.add(c);
		}

		Collections.sort(ll, new Comparator<Character>() {
			@Override
			public int compare(Character character, Character t1) {
				Integer left = hashMap.get(character);
				Integer right = hashMap.get(t1);
				if (left == null) left = Integer.MAX_VALUE;
				if (right == null) right = Integer.MAX_VALUE;
				return left - right;
			}
		});

		for(Character ch : ll) {
			ss.append(ch);
		}
    	return ss.toString();
    }
}
