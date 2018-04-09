package LeetCoding;

public class NumberOfSegmentsInAString {
    public static void main(String[] args) {
        System.out.println(countSegments("1"));
    }

    public static int countSegments(String s) {

        int result = 0;
        if (!"".equals(s.trim())) {
            String regex = "\\s+";
            String[] segments = s.trim().split(regex);
            result = segments.length;
        }
        return result;
    }
}
