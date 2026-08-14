class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> frqMap = new HashMap<>();
        for(char c:tasks) frqMap.put(c,frqMap.getOrDefault(c,0)+1);
        Queue<int[]> coolDown = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        for(int freq:frqMap.values()) maxHeap.offer(freq);
        int currentTime = 0;
        while(!maxHeap.isEmpty() || !coolDown.isEmpty()){
            while (!coolDown.isEmpty() && coolDown.peek()[1] <= currentTime) {
                int[] task = coolDown.poll();   
                maxHeap.offer(task[0]);
            }
            if(!maxHeap.isEmpty()){
                int highFreqTask = maxHeap.poll();
                currentTime++;
                highFreqTask--;
                if(highFreqTask>0){
                    coolDown.offer(new int[]{highFreqTask,n+currentTime});
                }
            }
            else{
                currentTime++;
            }
        }
        return currentTime;   
    }
}
