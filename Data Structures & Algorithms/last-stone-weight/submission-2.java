class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = Arrays.stream(stones).boxed().collect(Collectors.toList());
        pq.addAll(list);
        while(pq.size()>=2){
            int first = pq.poll();
            int second = pq.poll();
            if(first==second) continue;
            else pq.offer(first-second);
        
        }
        return pq.isEmpty()?0:pq.peek();        
    }
}
