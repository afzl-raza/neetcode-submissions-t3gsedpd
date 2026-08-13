class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        
        for(int i=0;i<=k;i++){
            int[] newDist = dist.clone();
            for(int[] flight:flights){
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                if(dist[from]!=Integer.MAX_VALUE && dist[from]+cost<newDist[to]){
                    newDist[to] = dist[from]+cost;
                }
                
            }
            dist = newDist;
        }
        int ans = (dist[dst]!=Integer.MAX_VALUE)? dist[dst]:-1;
        return ans;

    }
}
