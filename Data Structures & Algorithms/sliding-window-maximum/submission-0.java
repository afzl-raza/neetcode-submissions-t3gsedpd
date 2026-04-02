class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k==0 || k>nums.length){
            return new int[0];
        }
        Deque<Integer> deq = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        for (int i=0;i<k;i++){
            int curr = nums[i];
            while(!deq.isEmpty() &&curr>deq.peekLast()){
            deq.pollLast();
            }
            
            deq.offerLast(curr);
        }
        ans[0] = deq.peekFirst();
        for (int j=k;j<nums.length;j++){
            int n_elm = nums[j];
            int r_elm = nums[j-k];
            if (r_elm==deq.peekFirst()){
                deq.pollFirst();
            }
            while(!deq.isEmpty() &&  n_elm>deq.peekLast()){
            deq.pollLast();
            }
            
            deq.offerLast(n_elm);
            ans[j-k+1] = deq.peekFirst();
        }
        return ans;    
    }
}
