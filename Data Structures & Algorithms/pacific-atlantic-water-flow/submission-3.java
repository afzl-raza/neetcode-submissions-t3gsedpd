class Solution {
    private final int[] dRow = {-1, 1, 0, 0};
    private final int[] dCol = {0, 0, -1, 1};
    public void dfs(int i,int j,int[][] heights,boolean[][]visited){
        // Directions: Up, Down, Left, Right
        if(visited[i][j]) return;
        visited[i][j] = true;
        for (int d=0;d<4;d++){
            int nr = i+dRow[d];
            int nc = j+dCol[d];
            if(nr<0 || nr>=heights.length ||nc<0 || nc>=heights[0].length) continue;
            if (heights[nr][nc] >= heights[i][j]) {
                dfs(nr, nc, heights,visited);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        // Pacific based dfs
        for(int i=0;i<row;i++){
            dfs(i,0,heights,pacific);    
        }
        for(int j=0;j<heights[0].length;j++){
            dfs(0,j,heights,pacific); 
        }
        // Atlantic based dfs
        for(int i=0;i<row;i++){
            dfs(i,col-1,heights,atlantic);    
        }
        for(int j=0;j<heights[0].length;j++){
            dfs(row-1,j,heights,atlantic);
        }
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if(pacific[i][j] && atlantic[i][j]) ans.add(new ArrayList<>(List.of(i,j)));
            }
        }
        return ans;
    }
}
