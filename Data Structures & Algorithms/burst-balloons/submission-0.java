class Solution {
    public int helper(int[]nums, int i, int j, int[][]dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j] = -1;
        for(int k=i;k<=j;k++){
            dp[i][j]= Math.max(helper(nums,i,k-1,dp)+helper(nums,k+1,j,dp)+nums[i-1]*nums[k]*nums[j+1],dp[i][j]);

        }
        return dp[i][j];
    }
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for(int i = 0; i < n; i++){
            arr[i + 1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for (int[] row: dp) Arrays.fill(row,-1);
        return helper(arr,1,nums.length,dp);    
    }
}
