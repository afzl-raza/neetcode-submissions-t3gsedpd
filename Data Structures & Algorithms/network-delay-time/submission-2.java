class Solution {
    public void dijikstra(Map<Integer,List<int[]>> graph, int[] dist, int n, int src){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,src});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currNode = curr[1];
            int currDist = curr[0];
            if(currDist>dist[currNode-1]) continue;
            if(graph.get(currNode)!=null){
                for(int[] neigh:graph.get(currNode)){
                    int weight = neigh[1];
                    int neighNode = neigh[0];
                    if(dist[neighNode-1]> dist[currNode-1]+weight){
                        dist[neighNode-1] = currDist+weight;
                        q.offer(new int[]{dist[neighNode-1],neighNode});
                    }
                }
            }
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.computeIfAbsent(i, m->new ArrayList<>());
        }
        for(int[] edge:times){
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            graph.get(u).add(new int[]{v,time});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1] = 0;
        dijikstra(graph,dist,n,k);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
