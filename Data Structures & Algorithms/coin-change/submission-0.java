class Solution {
    public int minCoin(int[] coins,int amount,int dp[]){
        if(amount==0){
            return 0;
        }
        if(dp[amount]!=-1){
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin:coins){
            if(amount-coin>=0){
                int res = minCoin(coins,amount-coin,dp);
                if(res!=Integer.MAX_VALUE){
                    min = Math.min(min,1+res);
                }
            }
        }
        return dp[amount] = min;
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int res = minCoin(coins,amount,dp);
        if(res!=Integer.MAX_VALUE){
            return res;
        }
        return -1;

        
    }
}
