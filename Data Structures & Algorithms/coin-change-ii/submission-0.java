class Solution {
    
    public int  solve(int amount,int[]coins,int i,int[][]dp){
        if(amount==0){
            return 1;    
        }
       
        if(amount<0 || i>=coins.length){
            return 0;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int pick = solve(amount-coins[i],coins,i,dp);
        int skip = solve(amount,coins,i+1,dp);  
        return dp[i][amount]=pick+skip;
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[]row:dp)Arrays.fill(row,-1);
        return solve(amount,coins,0,dp);
        
        
    }
}
