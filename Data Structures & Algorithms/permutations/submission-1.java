class Solution {
    public void backTrack(int[] nums, List<Integer> curr, List<List<Integer>> ans, Set<Integer> isPresent){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
        }
        for(int num:nums){
            if(isPresent.contains(num)) continue;
            curr.add(num);
            isPresent.add(num);
            backTrack(nums,curr,ans,isPresent);
            curr.remove(curr.size()-1);
            isPresent.remove(num);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        
        Set<Integer> isPresent = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums,new ArrayList<>(), ans, isPresent);
        return ans;
    }
}
