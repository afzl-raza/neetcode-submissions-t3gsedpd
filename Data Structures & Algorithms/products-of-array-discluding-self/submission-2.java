class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count_zero = 0;
        int total_prod = 1;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                count_zero++;
            }
            total_prod*=nums[i];
        }
        int[] zero = new int[nums.length];
        if (count_zero==1){
            int indx = 0;
            int current = 1;
            for (int i=0;i<nums.length;i++){
                if (nums[i]==0){
                    indx = i;
                    continue;
                }
                current*=nums[i];
            }
            zero[indx] = current;
            return zero;
        }
        else if (count_zero>1){
            return zero;
        }
        else{
            for (int i=0;i<nums.length;i++){
                zero[i] = total_prod/nums[i];
            }
            return zero;
        }
        
    }
}  
