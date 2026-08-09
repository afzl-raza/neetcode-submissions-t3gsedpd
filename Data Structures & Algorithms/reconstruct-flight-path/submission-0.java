class Solution {
    public void dfs(String currAirport,Map<String,PriorityQueue<String>> graph, List<String> ans){
        if(currAirport==null) return ;
        PriorityQueue<String> pq = graph.get(currAirport);
        if(pq!=null){
            while(!pq.isEmpty()){
            String destination = pq.poll();
            dfs(destination,graph,ans);
            }
        }
        ans.add(currAirport);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket:tickets){
            String u = ticket.get(0);
            String v = ticket.get(1);
            graph.computeIfAbsent(u,key->new PriorityQueue<String>());
            graph.get(u).add(v);
        }
        List<String> tempAns = new ArrayList<>();
        dfs("JFK",graph,tempAns);
        Collections.reverse(tempAns);
        return tempAns;

    }
}
