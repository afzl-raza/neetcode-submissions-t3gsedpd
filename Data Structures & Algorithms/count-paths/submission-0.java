class Solution {
    public static int solve(int i,int j, int m,int n, int[][] dp){
        if(i>=m || j>=n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        return dp[i][j] = solve(i+1,j,m,n,dp)// down
                            +solve(i,j+1,m,n,dp);// right
                            // +solve(i,j-1,m,n,dp) // left
                            // +solve(i-1,j,m,n,dp); // up
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row:dp){
            Arrays.fill(row,-1);
        }
        return Solution.solve(0,0,m,n,dp);
        
    }
}
