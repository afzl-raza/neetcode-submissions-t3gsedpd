class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for(int i=1;i<nums.length+1;i++){
            xor = i^xor;
        }
        for(int i=0;i<nums.length;i++){
            xor = xor^nums[i];
        }
        return xor;
        
    }
}
