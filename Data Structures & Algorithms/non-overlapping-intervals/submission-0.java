class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int n = intervals.length;
        int prevEnd = intervals[0][1];
        int remove=0;
        for(int i=1;i<n;i++){
            if(prevEnd>intervals[i][0]){
                prevEnd = Math.min(prevEnd,intervals[i][1]);
                remove++;
            }
            else{
                prevEnd = intervals[i][1];
            }
        }
        // I am stuck here. Help me to get out of here.
        return remove;
        
    }
}
