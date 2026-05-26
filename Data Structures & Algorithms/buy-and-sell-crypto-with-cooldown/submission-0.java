class Solution {
    public int solve(int[] prices, int i, int canBuy,int[][]dp){
        if(i>=prices.length)return 0;
        if(dp[i][canBuy]!=-1)return dp[i][canBuy];
        if(canBuy==1){
            int buy = solve(prices,i+1,0,dp)-prices[i];
            int skip = solve(prices,i+1,1,dp);

            return dp[i][canBuy]=Math.max(buy,skip);
        }
        else{
            int sell = prices[i]+solve(prices,i+2,1,dp);
            int skip = solve(prices,i+1,0,dp);
            return dp[i][canBuy]=Math.max(sell,skip);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][n+1];
        for (int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(prices,0,1,dp);
        
    }
}
