package src.september;

public class Title392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("", "7"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int sLen = s.length();
        int tLen = t.length();
        int p = 0, q = 0;

        while (p < sLen && q < tLen) {
            //int tempQ = q;
            //int tempP = p;
            if (s.charAt(p) == t.charAt(q++)) {
                p++;
                //System.out.println(s.charAt(tempP) +"=="+t.charAt(tempQ));
                if (p == sLen) return true;
            } else {
                //System.out.println(s.charAt(tempP) + "!=" + t.charAt(tempQ));
            }
        }
        return false;
    }
}
