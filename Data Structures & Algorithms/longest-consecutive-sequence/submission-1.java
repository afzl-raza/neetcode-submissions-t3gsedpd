class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        int max_count = 1;
        int count = 1;
        for (int num:set){
            int current = num;
            if (!set.contains(current-1)){
                while (set.contains(current+1)){
                    current++;
                    count++;
                }
            }
            if (max_count<count){
                max_count = count;
            }
            count = 1;
        }
        return max_count;
    }
}
