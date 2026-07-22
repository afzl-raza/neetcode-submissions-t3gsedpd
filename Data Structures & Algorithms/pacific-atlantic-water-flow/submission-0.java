class Solution {
    public void dfs(int i,int j,int[][] heights,boolean[][] visited,boolean[]ocean){
        if(i>=heights.length || i<0 || j>=heights[0].length || j<0) return;
        if(visited[i][j]) return;
        visited[i][j] = true;
        if(i==0 || j==0) ocean[0]=true; // Pacific Condition
        if(i==heights.length-1 || j==heights[0].length-1) ocean[1] = true; // Atlantic condition
        if(ocean[0] && ocean[1]) return;
        int[] drow = {-1,1,0,0};
        int[] dcol = {0,0,1,-1};
        for (int d=0;d<4;d++){
            int r_n = i+drow[d];
            int c_n = j+dcol[d];
            if(r_n>=0 && r_n<heights.length && c_n>=0 && c_n<heights[0].length){
                if(heights[r_n][c_n]<=heights[i][j]) dfs(r_n,c_n,heights,visited,ocean);
            }
            
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>>  answer = new ArrayList<>(); 
        for (int i=0;i<heights.length;i++){
            for (int j=0;j<heights[0].length;j++){
                boolean[] ocean = new boolean[2];
                boolean[][] visited = new boolean[heights.length][heights[0].length];
                dfs(i,j,heights,visited,ocean);
                if (ocean[0] && ocean[1]){
                    answer.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }
        return answer;
        
    }
}
