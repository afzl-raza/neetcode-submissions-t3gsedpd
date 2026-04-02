class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int current_max = 0;
        int []prefix_max = new int[n];
        for (int i=0;i<n;i++){
            current_max = Math.max(current_max,height[i]);
            prefix_max[i] = current_max;
            
        }
        int curr = 0;
        int[] suffix_max = new int[n];
        for (int i=n-1;i>=0;i--){
            curr = Math.max(curr,height[i]);
            suffix_max[i] = curr;
            
        }
        int total_cap =0;
        for (int i=0;i<n;i++){
            int curr_cap = Math.min(prefix_max[i],suffix_max[i])-height[i];
            total_cap+=curr_cap;
        }
        return total_cap;
        
    }
}
