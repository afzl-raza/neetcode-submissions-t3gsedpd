class Solution {
    public int lenOfLIS(int[]nums,int i,int[]dp){
        if(i<0){
            return 0;
        }
        if(dp[i]!=1){
            return dp[i];
        }
        int max = 1;
        for(int j=i;j>=0;j--){
            if(nums[i]>nums[j]){
                int curr = 1+lenOfLIS(nums,j,dp);
                max = Math.max(curr,max);
            }
        }
        return dp[i]=max;
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1); // because every elm is a single subseq.
        int ans =1;
        for(int i=0;i<nums.length;i++){
            int curr=lenOfLIS(nums,i,dp);
            ans = Math.max(ans,curr);

        }
        return (ans);    
    }
}
