package LeetCoding.march.seventh;

import java.util.Vector;

public class RotatedDigits {

	public static void main(String[] args) {
		rotatedDigits(27);
	}
	
	public static int rotatedDigits(int N) {
		Vector<Integer> vector = new Vector<>();
		int count = 0;
		for(int i = 0; i <= N; i++) {
			boolean isValid = false;
			StringBuilder temp = new StringBuilder(String.valueOf(i));
			for(int j = 0; j < temp.length(); j++) {
				char digit = temp.charAt(j);
				isValid = !(digit == '3' || digit == '4' || digit == '7'); 
				if (!isValid)
					break;
				switch (digit) {
					case '0':
					case '1':
					case '8':
						break;
					case '2':
						temp.replace(j, j+1, "5");
						break;
					case '5':
						temp.replace(j, j+1, "2");
						break;
					case '6':
						temp.replace(j, j+1, "9");
						break;
					case '9':
						temp.replace(j, j+1, "6");
						break;					
				}
			}			
			if (isValid && !String.valueOf(i).equals(temp.toString())) {
				count ++;
				vector.add(i);
			}
		}
		for (int k=0; k<vector.size(); k++)
			System.out.println(vector.get(k));
        return count;
    }
}