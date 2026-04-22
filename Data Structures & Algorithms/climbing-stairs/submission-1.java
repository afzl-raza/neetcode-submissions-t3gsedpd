class Solution {
    public int climbStairsDp(int n,int i,int[] dp){
        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        dp[i] = climbStairsDp(n,i+1,dp)+climbStairsDp(n,i+2,dp);
        return dp[i];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int result =climbStairsDp(n,0,dp);
        return result;     
    }
}
