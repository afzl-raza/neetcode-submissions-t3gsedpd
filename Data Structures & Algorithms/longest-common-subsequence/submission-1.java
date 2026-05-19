class Solution {
    public int lcs(String x,String y,int i,int j,int m,int n,int[][]dp){
    if(i>=m|| j>=n){
        return 0;
    }
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    if(x.charAt(i)==y.charAt(j)){
        return dp[i][j]=1+lcs(x, y, i+1, j+1, m, n,dp);
    }
    else{
        int x_skip = lcs(x,y,i+1,j,m,n,dp);
        int y_skip = lcs(x,y,i,j+1,m,n,dp);
        return dp[i][j] = Math.max(x_skip,y_skip);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return lcs(text1,text2,0,0,text1.length(),text2.length(),dp);
        
    }
}
