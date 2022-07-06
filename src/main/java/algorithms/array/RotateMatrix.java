package algorithms.array;

public class RotateMatrix {
    public static void main(String[] args) {

    }

    boolean rotateMatrix(int[][] matrix) {
        int[][] temp = new int[5][];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                temp[i][j] = matrix[2-j][i];
            }
        }
        return true;
    }

}
