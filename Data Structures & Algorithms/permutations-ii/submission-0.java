class Solution {
    public void backTrack(int[] nums,int i, List<Integer> curr, List<List<Integer>> ans, Set<Integer> isPresent){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if (isPresent.contains(j)) continue;
            if(j>0 && nums[j]==nums[j-1] && !isPresent.contains(j-1)) continue;
            curr.add(nums[j]);
            isPresent.add(j);
            backTrack(nums,j+1, curr, ans, isPresent);
            curr.remove(curr.size()-1);
            isPresent.remove(j);
        }

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums,0,new ArrayList<>(), ans,new HashSet<>());
        return ans;

        
    }
}