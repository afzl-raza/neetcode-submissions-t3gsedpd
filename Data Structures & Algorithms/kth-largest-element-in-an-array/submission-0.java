class Solution {
    int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        for(int num:nums) add(num);
        return minHeap.peek();
    }
    void add(int num){
        minHeap.add(num);
        if(minHeap.size()>k) minHeap.poll();
    }
}
