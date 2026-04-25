class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            int tempMax = maxProduct;
            int tempMin = minProduct;
            maxProduct = Math.max(nums[i],Math.max(nums[i]*tempMax,nums[i]*tempMin));
            minProduct = Math.min(nums[i],Math.min(nums[i]*tempMax,nums[i]*tempMin));
            ans = Math.max(ans,maxProduct);
        }
        return ans;
        
    }
}
