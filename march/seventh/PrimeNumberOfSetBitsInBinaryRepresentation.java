package LeetCoding.march.seventh;

/**
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
 * @author rgk
 *
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

	public static void main(String[] args) {
		//System.out.println(countPrimeSetBits(6,10));
		System.out.print(countPrimeSetBits(10,15));
	}
	
	public static int countPrimeSetBits(int L, int R) {
		int countOfPrimeSetBits = 0;
		// convert to Binary number
		for (int k = L; k <= R; k++) {
			String binStr = Integer.toBinaryString(k);
			int countOfSetBits = 0;
			for (int i = 0; i<binStr.length(); i++) {
				if (binStr.charAt(i) == '1') {
					countOfSetBits ++;				
				}
			}
			if (isPrimary(countOfSetBits)) {
				countOfPrimeSetBits ++;
				System.out.println("current binstr == "+binStr);
			}
		}
        return countOfPrimeSetBits;
    }
	
	private static boolean isPrimary(int number) {
		if (number == 1) return false;
		for (int j = 2; j <= number/2; j++) {
			if(number%j == 0)
				return false;
		}
		return true;
	}

}
