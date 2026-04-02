class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int current = 1;
        int n = nums.length;
        for (int i=0;i<n;i++){
            if (i>0){
                current*=nums[i-1];
            }
            prefix[i] = current;
        }
        int curr =1;
        for (int j=n-1;j>-1;j--){
            if (j+1<n){
                curr*= nums[j+1];
            }
            suffix[j] = curr;
        }
        for (int i=0;i<nums.length;i++){
            nums[i] = prefix[i]*suffix[i];
        }
        return nums;
        
    }
}  
