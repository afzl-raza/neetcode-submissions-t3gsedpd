class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        boolean newAdded =false;
        List<int[]> output = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int[] curr = intervals[i];
            if(curr[1]<newInterval[0]){
                // int start = Math.min(curr[0],newInterval);
                // int end = Math.max(curr[1])
                output.add(curr);
            }
            else if(curr[0]>newInterval[1]){
                if(!newAdded){
                    output.add(newInterval);
                    newAdded=true;
                }
                output.add(curr);
            }
            else{
                newInterval[0] = Math.min(curr[0],newInterval[0]);
                newInterval[1] = Math.max(curr[1],newInterval[1]);
            }
        }
        if(!newAdded) output.add(newInterval);
        return output.toArray(new int[0][]);
        
    }
}
