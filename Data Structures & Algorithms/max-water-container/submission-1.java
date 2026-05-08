class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left =0;
        int right = n-1;
        int max_cap = 0;
        while (left<right){
            int w = right-left;
            if (height[left]<height[right]){
                int cap = w*height[left];
                max_cap = Math.max(max_cap,cap);
                left++;
            }
            else if(height[left]>height[right]){
                int cap = w*height[right];
                max_cap = Math.max(max_cap,cap);
                right--;
            }
            else{
                int cap = w*height[left];
                max_cap = Math.max(max_cap,cap);
                left++;
            }
        }
        return max_cap;
        
    }
}

