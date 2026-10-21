class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0;
        int curr = 0;
        int min = Integer.MAX_VALUE;
        for(int r=0;r<n;r++){
            curr+=nums[r];
            while(curr>=target){
                int currLen = r-l+1;
                min = Math.min(currLen,min);
                curr-=nums[l];
                l++;
            }

        }
        return (min!=Integer.MAX_VALUE)?min:0;    
    }
}