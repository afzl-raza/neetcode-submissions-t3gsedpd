class Solution {
    public boolean canPart(int[] nums,int i, int target,int[][] dp){
        if(target==0){
            return true;
        }
        if(i==nums.length && target>0){
            return false;
        }
        if(dp[i][target]!=-1){
            return dp[i][target]==1;
        }
        boolean include = false;
        if(nums[i]<=target){
            include = canPart(nums,i+1,target-nums[i],dp);
        }
        boolean exclude = canPart(nums,i+1,target,dp);
        dp[i][target] = (include||exclude)?1:0;
        return dp[i][target]==1;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num:nums){
            totalSum+=num;
        }
        if(totalSum%2!=0){
            return false;
        }
        int target = totalSum/2;
        int[][] dp = new int[nums.length][target+1];
        // Arrays.fill(dp,-1);
        for (int i=0;i<nums.length;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = -1;
            }
        }
        return canPart(nums,0,target,dp);    
    }
}
