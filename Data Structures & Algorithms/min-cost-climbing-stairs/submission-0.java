class Solution {
    public int minCostClimbing(int[] cost,int[]dp,int i){
        if(i>=cost.length){
            return 0;
        }
        if(i==cost.length-1){
            return cost[i];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        dp[i]=Math.min(minCostClimbing(cost,dp,i+1),minCostClimbing(cost,dp,i+2))+cost[i];
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(minCostClimbing(cost,dp,0),minCostClimbing(cost,dp,1));

        
    }
}
