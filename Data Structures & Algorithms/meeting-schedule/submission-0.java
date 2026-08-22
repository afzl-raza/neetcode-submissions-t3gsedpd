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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        int n = intervals.size();
        for(int i=1;i<n;i++){
            if(intervals.get(i-1).end>intervals.get(i).start) return false;
        }
        return true;

    }
}
