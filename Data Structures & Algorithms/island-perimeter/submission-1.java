class Solution {
    public static int dfs(int[][] grid, int i, int j,boolean[][] visited){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0){
            return 1;
        }
        else if (grid[i][j]==0){
            return 1;
        }
        // if(visited[i][j]) return 0;
        int count = 0;
        if(grid[i][j]==1 && !visited[i][j]){
            visited[i][j] = true;
            count+= dfs(grid, i+1,j,visited);
            count+= dfs(grid, i-1,j,visited);
            count+= dfs(grid, i,j+1,visited);
            count+= dfs(grid, i,j-1,visited);     
        }
        return count;
    }
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    count+= dfs(grid,i,j,visited);
                }
            }
        }
        return count;
        
        
    }
}