class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int max_count = Integer.MIN_VALUE;
        int count = 1;
        for (int num:nums){
            int current = num;
            while (map.containsKey(current+1)){
                current++;
                count++;
            }
            if (max_count<count){
                max_count = count;
            }
            count = 1;
        }
        return max_count;
    }
}
