class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lRow = 0;
        int rRow = matrix.length-1;
        while(lRow<=rRow){
            int midRow = lRow+(rRow-lRow)/2;
            int x = matrix[midRow][0];
            int r = matrix[0].length-1; // extreme right;
            int y = matrix[midRow][r];   
            if(x<= target && y>=target){
                int newL = 0;
                int newR = matrix[0].length-1;
                while(newL<=newR){
                    int midCol = newL+(newR-newL)/2;
                    if(matrix[midRow][midCol]==target) return true;
                    else if(matrix[midRow][midCol]>target) newR = midCol-1;
                    else{
                        newL = midCol+1;
                    }
                }
                return false;
            }
            else if(x>=target && y>=target) rRow = midRow-1;
            else{
                lRow = midRow+1;
            }

        }
        return false;    
    }
}
