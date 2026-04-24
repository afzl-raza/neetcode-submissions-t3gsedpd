class Solution {
    public int maxProfit(int[] nums,int start,int end, int[] dp){
        if(start<end){
            return 0;
        }
        if(start==end){
            return nums[start];
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int curr = nums[start]+maxProfit(nums,start-2,end,dp);
        int skip = maxProfit(nums,start-1,end,dp);
        dp[start] = Math.max(skip,curr);
        return dp[start];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp1 = new int[nums.length+1];
        Arrays.fill(dp1,-1);
        int[] dp2 = new int[nums.length+1];
        Arrays.fill(dp2,-1);
        int first = maxProfit(nums,n-1,1,dp1);
        int second = maxProfit(nums,n-2,0,dp2);
        return Math.max(first,second);
    }
}
