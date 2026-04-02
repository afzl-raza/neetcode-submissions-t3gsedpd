class Solution {
    int a =0;
    int[][] grid;
    int max_a = 0;
    public void dfs(int row,int col){
        if (row<0||row>=grid.length||col<0||col>=grid[0].length||grid[row][col]!=1){
            return;
        }
        grid[row][col]=0;
        a++;
        dfs(row+1,col);
        dfs(row-1,col);
        dfs(row,col+1);
        dfs(row,col-1);
    }
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    dfs(i,j);
                    max_a=Math.max(a,max_a);
                    a = 0;
                }
            }
        }   
        return max_a;    
    }
}
