class Solution {
    public void subset(int[] nums, int i, int[] total, int xor){
        if(i>=nums.length){
            total[0]+= xor;
            return;
        }
        //The child modified its own copy. The parent's          xor remained unchanged.
// Therefore, the parent doesn't need to undo the child's changes.
        subset(nums,i+1, total, xor);
        // curr.add(nums[i]);
        xor = xor^nums[i];
        subset(nums,i+1, total, xor);
        // xor = xor^curr.remove(curr.size()-1);
        // curr.remove(curr.size()-1);

    }
    public int subsetXORSum(int[] nums) {
        int[] total = new int[1];
        subset(nums,0, total, 0);
        return total[0];
        
    }
}