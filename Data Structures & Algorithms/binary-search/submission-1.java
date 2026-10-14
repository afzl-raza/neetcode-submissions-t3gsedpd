class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
                // Punch line:
                // Closed interval: r = n-1, l <= r, move to mid ± 1.
                // Half-open interval: r = n, l < r, right boundary becomes mid.

                // Remember the intuition:
                // - Closed [l, r] — both ends are included, so when mid is not the answer, eliminate it using mid - 1 or mid + 1.
                // - Half-open [l, r) — l is included, but r is excluded, so use r = mid when searching the left half.
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) r = mid;
            else{
                 l= mid+1;
            }
        }
        return -1;
        
    }
}
