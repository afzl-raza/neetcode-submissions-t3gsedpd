class Solution {
    public int solve(int[] nums, int target, int i,int[][]dp,int offset){
        if(i>=nums.length){
            return target==0?1:0;
        }
        if (target + offset < 0 || target + offset >= dp[0].length) {
            return 0;
        }
        if(dp[i][target+offset]!=-1)return dp[i][target+offset];
        int plus = solve(nums,target-nums[i],i+1,dp,offset);
        int minus = solve(nums,target+nums[i],i+1,dp,offset);
        return dp[i][target+offset]=plus+minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num:nums)sum+=num;
        if(Math.abs(target)>sum)return 0;
        int[][] dp = new int[nums.length][2 * sum + 1];
        for(int[]row:dp)Arrays.fill(row,-1);
        return solve(nums,target,0,dp,sum);
        
    }
}
