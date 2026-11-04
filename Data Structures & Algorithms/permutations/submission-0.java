class Solution {
    public void backTrack(int[] nums, List<Integer> curr, List<List<Integer>> ans, Set<Integer> isPresent){
        if(curr.size()==nums.length){
            System.out.println(curr);
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int num:nums){
            if(isPresent.contains(num)) continue;
            curr.add(num);
            isPresent.add(num);
            backTrack(nums, curr, ans, isPresent);
            curr.remove(curr.size()-1);
            isPresent.remove(num);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> isPresent = new HashSet<>();
        backTrack(nums,curr,ans,isPresent);
        return ans;
        
    }
}
