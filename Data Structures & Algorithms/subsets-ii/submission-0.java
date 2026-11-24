class Solution {
    public void backTrack(int[] nums, int i, List<Integer> curr, List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));
        for(int j=i;j<nums.length;j++){
            if(j>i && nums[j]==nums[j-1]) continue;
            curr.add(nums[j]);
            backTrack(nums,j+1,curr,ans);
            curr.remove(curr.size()-1);
            
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums,0,new ArrayList<>(),ans);
        return ans;
        
    }
}
