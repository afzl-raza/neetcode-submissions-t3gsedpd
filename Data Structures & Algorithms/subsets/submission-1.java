class Solution {
    public void  backTrack(int[] nums, int i,List<Integer> curr, List<List<Integer>> ans){
        if(i>=nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        backTrack(nums, i+1, curr, ans);
        curr.add(nums[i]);
        backTrack(nums, i+1,curr, ans);
        curr.remove(curr.size()-1);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>(), ans);
        return ans;

        
    }
}
