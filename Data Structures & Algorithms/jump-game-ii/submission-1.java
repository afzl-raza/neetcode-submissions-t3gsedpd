class Solution {
    public int jump(int[] nums) {
        int currentEnd = 0;
        int farthest = 0;
        int jump = 0;

        for(int i=0;i<nums.length-1;i++) {
            farthest = Math.max(farthest, i + nums[i]);
        
            if(i==currentEnd){
                jump++;
                currentEnd = farthest;
            }
            
        }
        return jump;
    }
}
