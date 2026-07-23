class Solution {
    private final int[] dRow = {-1,1,0,0};
    private final int[] dCol = {0,0,1,-1};
    public void dfs(int i, int j,char[][] board, boolean[][] visited){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='X') return;
        if(visited[i][j]) return;
        visited[i][j] = true;
        for (int d=0;d<4;d++){
            int dr = i+dRow[d];
            int dc = j+dCol[d];
            if(dr>=0 && dr<board.length &&  dc>=0 && dc<board[0].length && board[dr][dc]=='O'){
                dfs(dr,dc,board,visited);
            }
        }
    }
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0;i<row;i++){
            dfs(i,0,board,visited);
            dfs(i,col-1,board,visited);
        }
        for (int j=0;j<col;j++){
            dfs(0,j,board,visited);
            dfs(row-1,j,board,visited);
        }
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(!visited[i][j] && board[i][j]=='O' ){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
