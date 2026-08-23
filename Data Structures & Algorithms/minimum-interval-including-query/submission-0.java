class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0])); //sotre the length and the end;
        int[][] sortedQueries = new int[n][2];
        for(int i=0;i<n;i++){
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries,(a,b)->Integer.compare(a[0],b[0]));
        int[] ans = new int[n];
        int intervalIndx = 0;
        for(int[] query:sortedQueries){
            int ansIndx = query[1];
            int q = query[0];
            while(intervalIndx<intervals.length && intervals[intervalIndx][0]<=q){
                int end = intervals[intervalIndx][1];
                int start = intervals[intervalIndx][0];
                int length = end-start+1;
                minHeap.offer(new int[]{length,end});
                intervalIndx++;
            }
            while(!minHeap.isEmpty() && q>minHeap.peek()[1]) minHeap.poll();
            if(minHeap.isEmpty()) ans[ansIndx] =-1;
            else{
                ans[ansIndx] = minHeap.peek()[0];
            }
        }
        return ans;
        
    }
}
