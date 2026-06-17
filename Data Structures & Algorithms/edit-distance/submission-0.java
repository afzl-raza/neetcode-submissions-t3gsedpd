class Solution {
    public int helper(String word1,String word2,int i,int j,int[][] dp){
        if(i>=word1.length()) return word2.length()-j;  // insertion 
        if(j>=word2.length()) return word1.length()-i; // deletion
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)) return dp[i][j]=helper(word1,word2,i+1,j+1,dp);
        int insert = 1+helper(word1,word2,i,j+1,dp); 
        int delete = 1+helper(word1,word2,i+1,j,dp);
        int replace = 1+helper(word1,word2,i+1,j+1,dp);
        return dp[i][j] = Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return helper(word1,word2,0,0,dp); 
    }
}
