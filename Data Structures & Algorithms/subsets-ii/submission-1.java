class Solution {
    public void backTrack(int[] nums, int i,
                          List<Integer> curr, Set<List<Integer>> ans) {

        if (i >= nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Include
        curr.add(nums[i]);
        backTrack(nums, i+1, curr, ans);

        // Backtrack
        curr.remove(curr.size()-1);

        // Exclude
        backTrack(nums, i+1, curr, ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        backTrack(nums, 0, new ArrayList<>(), ans);

        return new ArrayList<>(ans);
    }
}

