class Solution {
    char[][] grid;
    public void dfs(int row,int col){
        if(row<0||row>=grid.length||col<0||col>=grid[0].length||grid[row][col]!='1'){
            return;
        }
        grid[row][col] ='0';
        dfs(row,col-1);
        dfs(row,col+1);
        dfs(row-1,col);
        dfs(row+1,col);
    } 
    public int numIslands(char[][] grid) {
        int count=0;
        this.grid = grid;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;   
    }
}
