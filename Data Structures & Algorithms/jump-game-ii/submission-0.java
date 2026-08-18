class Solution {
    public int jump(int[] nums) {
        int i = 0;
        int currentEnd = 0;
        int farthest = 0;
        int jump = 0;

        while (currentEnd<nums.length-1) {
            while(i<=currentEnd){
                farthest = Math.max(farthest, i + nums[i]);
                i++;
            }
            jump++;
            currentEnd = farthest;
        }
        return jump;
    }
}
