class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] last = output.get(output.size()-1);
            int[] curr = intervals[i];
            if(curr[0]<=last[1]){
                output.remove(output.size()-1);
                int start = Math.min(curr[0],last[0]);
                int end = Math.max(curr[1],last[1]);
                output.add(new int[]{start,end});
                continue;
            }

            output.add(curr);
        }
        return output.toArray(new int[0][]);
        
    }
}
