/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0) return 0;
        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        int n = intervals.size();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals.get(0).end);
        int max = 1;
        for(int i=1;i<n;i++){
            if(minHeap.peek()<=intervals.get(i).start){
                minHeap.poll();
                minHeap.offer(intervals.get(i).end);
            }
            else{
                minHeap.offer(intervals.get(i).end);
            }
            max = Math.max(max,minHeap.size());
        }
        return max;

    }
}
