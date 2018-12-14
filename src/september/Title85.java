package src.september;

public class Title85 {
    public static void main(String[] args) {
        maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}});
    }

    public static int maximalRectangle(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            char[] rowChars = matrix[i];
            for (int j = 0; j < rowChars.length; j++) {
                System.out.print(matrix[i][j]+", ");

                if (matrix[i][j] == '1') {
                    //int r = i, c = j;
                    for (int k = i; k < matrix.length; k++) {
                        if (matrix[k][j] != '1') {

                            break;
                        }
                    }
                }
            }
            System.out.println();
        }
        return 0;
    }
}
