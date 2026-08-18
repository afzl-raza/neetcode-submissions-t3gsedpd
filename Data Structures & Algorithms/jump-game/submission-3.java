class Solution {
    public boolean checkJump(int[] nums, int indx,int[] canReach){
        if(canReach[indx]!=-1) return canReach[indx]==1;
        if(indx<nums.length-1 && nums[indx]==0){
            canReach[indx] = 0;
            return false;
        }
        if(indx==nums.length-1) {
            canReach[indx] = 1;
            return true;
        }
        for(int i=indx+1;i<=indx+nums[indx];i++){
            if(checkJump(nums,i,canReach)) {
                canReach[indx] =1;
                return true;
            }
        }
        canReach[indx] =0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int[] canReach = new int[nums.length];
        Arrays.fill(canReach,-1);
        return checkJump(nums,0,canReach);    
    }
    
}
