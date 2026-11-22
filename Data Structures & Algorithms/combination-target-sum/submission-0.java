class Solution {
    public void backTrack(int[] nums, int i, List<Integer> curr, int sum, int target,List<List<Integer>> ans){
        if(sum==target){
            ans.add(List.copyOf(curr));
            return;
        }
        else if(sum>target || i>=nums.length) return;
        curr.add(nums[i]);
        backTrack(nums,i,curr,sum+nums[i],target,ans);
        curr.remove(curr.size()-1);
        backTrack(nums,i+1,curr,sum,target,ans);
        

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums,0,new ArrayList<>(), 0,target,ans);
        return ans;
    }
}
