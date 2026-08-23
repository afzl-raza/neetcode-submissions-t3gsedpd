class Solution {
    public void reverse(int[][] matrix){
        int n = matrix.length;
        for(int r=0;r<n;r++){
            for(int c=0;c<matrix[0].length/2;c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][n-c-1];
                matrix[r][n-c-1] = temp;
            }
        }
    }
    public void transpose(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;   
            }
        }
    }
    public void rotate(int[][] matrix) {
        // reverse(matrix);
        transpose(matrix);
        reverse(matrix);
        
    }
}
