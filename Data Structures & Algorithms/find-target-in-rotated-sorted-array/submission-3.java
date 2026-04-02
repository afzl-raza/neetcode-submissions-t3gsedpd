class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l<r){
            int mid = (l+r)/2;
            if (nums[mid]<nums[r]){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        int left =0;
        int right=l-1;
        if (l==0){
            int l1 =0;
            int r1=nums.length-1;
            while (l1<=r1){
                int m1 = (l1+r1)/2;
                if (nums[m1]==target){
                    return m1;
                }
                else if (nums[m1]>target){
                    r1 = m1-1;
                }
                else{
                    l1 = m1+1;
                }
            }
            return -1;
        }
        else if (target>=nums[0] && target<=nums[l-1]){
            while (left<=right){
                int mid = (left+right)/2;
                if (nums[mid]==target){
                    return mid;
                }
                else if (nums[mid]>target){
                    right = mid-1;
                    
                }
                else{
                    left = mid+1;
                }
            }
        }
        else{
            int left2 = l;
            int right2= nums.length-1;
            while (left2<=right2){
                int mid2 = (left2+right2)/2;
                if (nums[mid2]==target){
                    return mid2;
                }
                else if (nums[mid2]>target){
                    right2 = mid2-1;
                }
                else{
                    left2 = mid2+1;
                }
            }   
        }
        return -1;    
    }
}
