package LeetCoding.march.seventh;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LetterCasePermutation {

	public static void main(String[] args) {
		
		letterCasePermutation("");
	}
	
	public static List<String> letterCasePermutation(String S) {
		StringBuilder temp = new StringBuilder();
		List<String> resultList = new LinkedList<>();
		Map<Integer, Character> hashMap = new HashMap<>();
		for (int c = 0; c < S.length(); c++) {
			if (Character.isLetter(S.charAt(c))) {
				temp.append(S.charAt(c));
			} else {
				hashMap.put(c, S.charAt(c));
			}
		}
		
		for (int i = 0; i< 1<<temp.length(); i++) {
			String ss = "";
			String binStr = Integer.toBinaryString(i);
			// add '0' in high bit
			while (binStr.length() < temp.length()) {
				binStr = "0" + binStr;
			}
			for (int k = 0; k < temp.length() ; k++) {
				if (binStr.charAt(k) == '1') {
					ss += Character.toUpperCase(temp.charAt(k));
				} else {
					ss += Character.toLowerCase(temp.charAt(k));
				}				
			}
		
			// insert digit into strin ss
			StringBuilder result = new StringBuilder(ss);
			Iterator<Integer> it = hashMap.keySet().iterator();
			while (it.hasNext()) {
				int ii = it.next();
				result.insert(ii, hashMap.get(ii));
			}
			resultList.add(result.toString());			
		}		
        return resultList;
    }

}
