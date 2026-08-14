class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        for(int stone:stones) pq.offer(stone);
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            if(first==second) continue;
            else pq.offer(first-second);
        
        }
        return pq.isEmpty()?0:pq.peek();        
    }
}
