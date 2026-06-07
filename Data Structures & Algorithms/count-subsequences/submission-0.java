class Solution {
    public int helper(String s, String t, int i, int j,Integer[][] dp){
        if(dp[i][j]!=null) return dp[i][j];
        if(j>=t.length()) return 1;
        if(i>=s.length()) return 0;
        int sum = 0;
        if(s.charAt(i)==t.charAt(j)){
            sum+= helper(s,t,i+1,j+1,dp)+helper(s,t,i+1,j,dp);
        }
        else{
            sum+= helper(s,t,i+1,j,dp);
        }
        return dp[i][j]=sum;
    }
    public int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length()+1][t.length()+1];
        // for (Integer[] row:dp)Arrays.fill(row,-1);
        return helper(s,t,0,0,dp);
        
    }
}
