class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minCost = new int[n];
        int maxVal = Integer.MAX_VALUE;
        Arrays.fill(minCost,maxVal);
        boolean[] visited = new boolean[n];
        minCost[0] = 0;
        int total = 0;
        
        for(int count=0;count<n;count++){
            int min =Integer.MAX_VALUE;
            int nextPoint = -1;
            for (int i=0;i<n;i++){
                if(!visited[i] && minCost[i]<min){
                    min = minCost[i];
                    nextPoint = i;
                }
            }
            visited[nextPoint] = true;
            total+=min;
            for(int j=0;j<n;j++){
                if(!visited[j]){
                    int cost = Math.abs(points[j][0]-points[nextPoint][0]) + Math.abs(points[j][1]-points[nextPoint][1]);
                    minCost[j] = Math.min(minCost[j],cost);
                }
            }
        }
        return total;
    }
}
