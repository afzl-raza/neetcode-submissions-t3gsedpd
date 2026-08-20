class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer,Integer> freqMap = new HashMap<>();
        if(hand.length % groupSize != 0) return false;
        for(int num:hand){
            if(!freqMap.containsKey(num)){
                minHeap.offer(num);
            }
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        int innerLoop = hand.length/groupSize;
        for(int i=0;i<innerLoop;i++){
            int smallest = minHeap.peek();
            for(int j=0;j<groupSize;j++){
                int required = smallest+j;
                if(!freqMap.containsKey(required)||freqMap.get(required)==0){
                    return false;
                }
                freqMap.put(required,freqMap.get(required)-1);
                if(freqMap.get(required)==0) minHeap.remove(required);
            }
        }
        return true;
    }
}
