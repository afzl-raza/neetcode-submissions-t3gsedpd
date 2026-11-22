class Solution {
    public void subset(int[] nums, int i, List<Integer> curr, int[] total, int xor){
        if(i>=nums.length){
            total[0]+= xor;
            return;
        }
        subset(nums,i+1,curr, total, xor);
        curr.add(nums[i]);
        xor = xor^nums[i];
        subset(nums,i+1,curr, total, xor);
        // xor = xor^curr.remove(curr.size()-1);
        curr.remove(curr.size()-1);

    }
    public int subsetXORSum(int[] nums) {
        int[] total = new int[1];
        subset(nums,0, new ArrayList<>(), total, 0);
        return total[0];
        
    }
}