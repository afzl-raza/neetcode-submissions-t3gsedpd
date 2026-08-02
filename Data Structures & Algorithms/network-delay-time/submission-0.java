class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       int[] dist = new int[n+1];
       int posInf = Integer.MAX_VALUE;
       Arrays.fill(dist,posInf);
       dist[k] = 0;
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
       pq.offer(new int[]{k,0});
       Map<Integer,List<int[]>> graph = new HashMap<>();
       for(int[] edge:times){
        int u = edge[0];
        int v = edge[1];
        int edgeWeight = edge[2]; // travel time from source to this node.
        if (!graph.containsKey(u)){
            graph.put(u,new ArrayList<>());    
        }
        List<int[]> neigh = graph.get(u);
        neigh.add(new int[]{v,edgeWeight});        
       }
       while(!pq.isEmpty()){
        int[] curr = pq.poll();
        int currNode  = curr[0];
        int currDist = curr[1]; //current shortest distance
        if (currDist > dist[currNode]) {
            continue;
        }
        if(graph.containsKey(currNode)){
        for (int[] neigh:graph.get(currNode)){
            int neighNode = neigh[0];
            int edgeWeight = neigh[1]; // edge weight between current and neigh.
            //if(currentDistance+edgeWeight < dist[neighbor]) stuck here like I do not how to update the disstance..
            if(currDist+edgeWeight<dist[neighNode]){
                dist[neighNode] = currDist+edgeWeight;
                pq.add(new int[]{neighNode,dist[neighNode]});
            }   
        }
    }
}
    int ans = 0;
    for (int i=1;i<dist.length;i++){
        if(dist[i]==posInf)return -1;
        ans = Math.max(dist[i],ans);
    }
    return ans;
    }
}
