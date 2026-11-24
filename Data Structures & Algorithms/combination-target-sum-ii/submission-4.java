class Solution {

    public void backTrack(int[] nums,int i, int target, int sum, List<Integer> curr, List<List<Integer>> ans){
        if(sum==target){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target || i>=nums.length) return;
        for(int j=i;j<nums.length;j++){
            if(j>i && nums[j]==nums[j-1]) continue;
            curr.add(nums[j]);
            backTrack(nums,j+1, target,sum+nums[j], curr, ans);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(candidates,0, target, 0, new ArrayList<>(), ans);
        return ans;
        
    }
}
