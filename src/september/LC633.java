package src.september;

public class LC633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(13));
    }

    public static boolean judgeSquareSum(int c) {
        double sqrtC = Math.sqrt(c);
        for (int i = 0; i < sqrtC+1; i++) {
            int b = c - i*i;
            int sqrtB = (int) Math.sqrt(b);
            if (sqrtB*sqrtB == b) return true;
        }
        return false;
    }
}
