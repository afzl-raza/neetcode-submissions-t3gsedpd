class Solution {
    public void dfs(int node,boolean[]visited,List<List<Integer>>graph){
        visited[node] = true;
        for(int neigh:graph.get(node)){
            if(!visited[neigh]){
                dfs(neigh,visited,graph);
            }
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges.length!=n-1){
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        // build graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        dfs(0,visited,graph);
        for(int i=0;i<n;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;


    }
}
