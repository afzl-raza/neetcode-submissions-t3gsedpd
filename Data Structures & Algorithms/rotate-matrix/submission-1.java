class Solution {

    public void reverse(int[][] matrix) {
        int n = matrix.length;

        for (int r = 0; r < n / 2; r++) {
            int[] temp = matrix[r];
            matrix[r] = matrix[n - r - 1];
            matrix[n - r - 1] = temp;
        }
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void rotate(int[][] matrix) {
        reverse(matrix);
        transpose(matrix);
    }
}