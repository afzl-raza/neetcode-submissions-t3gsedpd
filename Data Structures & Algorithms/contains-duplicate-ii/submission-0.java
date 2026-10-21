class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=k+i;j++){
                if( j<n && nums[i]==nums[j]) return true;
            }
        }
        return false;
        
    }
}