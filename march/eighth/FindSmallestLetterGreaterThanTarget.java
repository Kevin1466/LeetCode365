package LeetCoding.march.eighth;

public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		System.out.println(nextGreatestLetter(new char[] {'c','f','j'}, 'a'));
		System.out.println(nextGreatestLetter(new char[] {'c','f','j'}, 'c'));
		System.out.println(nextGreatestLetter(new char[] {'c','f','j'}, 'd'));
		System.out.println(nextGreatestLetter(new char[] {'c','f','j'}, 'g'));
		System.out.println(nextGreatestLetter(new char[] {'c','f','j'}, 'j'));
		System.out.println(nextGreatestLetter(new char[] {'c','f','j'}, 'k'));
	}
	
    public static char nextGreatestLetter(char[] letters, char target) {
    	char lastCh = letters[letters.length - 1];
    	char firstCh = letters[0];
    	if (lastCh <= target) {
    		return firstCh;
    	}
    	for (int i = 0; i<letters.length; i++) {
    		if (letters[i] > target) {
    			return letters[i];
    		}
    	}
    	return '\u0000';
    }
}
