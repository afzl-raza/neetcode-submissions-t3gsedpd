class Solution {
    public int best_dp(int[] nums,int[] dp,int i){
        if(i<0){
            return 0;
        }
        if(i==0){
            return nums[0];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int rob = nums[i]+best_dp(nums,dp,i-2);
        int skip = best_dp(nums,dp,i-1);
        dp[i] = Math.max(rob,skip);
        return dp[i];

    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return best_dp(nums,dp,nums.length-1);
        
    }
}
