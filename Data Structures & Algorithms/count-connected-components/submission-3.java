class Solution {
    void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited){
        if(visited[node]) return;
        visited[node] = true;
        if(graph.get(node)!=null && !graph.get(node).isEmpty()){
            for(int neigh:graph.get(node)){
                dfs(neigh, graph,visited);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            graph.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,graph,visited);
                components++;
            }
        }
        return components;

    }
}
