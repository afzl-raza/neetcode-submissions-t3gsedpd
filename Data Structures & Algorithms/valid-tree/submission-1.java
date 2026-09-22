class Solution {
    boolean dfs(int node, int parent,Map<Integer,List<Integer>> graph,boolean[] visited){
        visited[node] =true;
        if(graph.get(node)!=null && !graph.get(node).isEmpty()){
            for(int neigh:graph.get(node)){
                if(!visited[neigh]){
                    if(dfs(neigh,node,graph,visited)) return true;
                }
                else if(neigh!=parent) return true;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        Map<Integer,List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        for(int[] preq:edges){
            int u = preq[0];
            int v = preq[1];
            map.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            map.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(dfs(i,-1,map,visited)) return false;
            }
        }
        return true;

    }
}
