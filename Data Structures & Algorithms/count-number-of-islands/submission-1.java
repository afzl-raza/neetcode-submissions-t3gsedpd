class Solution {
    void dfs(char[][]grid, int i, int j,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0') return ;
        if(visited[i][j]) return;
        visited[i][j] = true;
        dfs(grid,i+1,j,visited);
        dfs(grid,i-1,j,visited);
        dfs(grid,i,j+1,visited);
        dfs(grid,i,j-1,visited);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
        
    }
}
