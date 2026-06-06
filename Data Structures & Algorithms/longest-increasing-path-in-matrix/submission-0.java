class Solution {
    public int helper(int[][] matrix,int i,int j,int[][]dp){
        if(dp[i][j]!=-1) return dp[i][j]; 
        int max=1;
        if(i+1>=0 && i+1<matrix.length && j>=0 && j<matrix[0].length && matrix[i+1][j]>matrix[i][j]){
            max = Math.max(max,1+helper(matrix,i+1,j,dp));
            
        }
        if( i-1>=0 && i-1<matrix.length && j>=0 && j<matrix[0].length && matrix[i-1][j]>matrix[i][j]){
            max = Math.max(max,1+helper(matrix,i-1,j,dp));
        }
        if (i>=0 && i<matrix.length && j-1>=0 && j-1<matrix[0].length && matrix[i][j-1]>matrix[i][j]){
            max = Math.max(max,1+helper(matrix,i,j-1,dp));
        }
        if(i>=0 && i<matrix.length && j>=0 && j+1<matrix[0].length && matrix[i][j+1]>matrix[i][j]){
            max = Math.max(max,1+helper(matrix,i,j+1,dp));
        }
        return dp[i][j]= max;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] row:dp){
            Arrays.fill(row,-1);
        }
        int max = 0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                int curr = helper(matrix,i,j,dp);
                max = Math.max(curr,max);
            }
        }
        return max;   
    }
}
