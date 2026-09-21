class Solution {
    void bfs(char[][] board, Queue<int[]> q){
        int m = board.length;
        int n = board[0].length;
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] d: dir){
                int newR = d[0]+curr[0];
                int newC = d[1]+curr[1];
                if(newR<0 || newR>=m || newC<0 || newC>=n || board[newR][newC]!='O') continue;
                board[newR][newC] = 'S';
                q.offer(new int[]{newR,newC});
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                board[i][0] = 'S';
                q.offer(new int[]{i,0});
                
            }
            if(board[i][n-1]=='O'){
                board[i][n-1] = 'S';
                q.offer(new int[]{i,n-1});
            }
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                board[0][j] = 'S';
                q.offer(new int[]{0,j});
            }
            if(board[m-1][j]=='O'){
                board[m-1][j] = 'S';
                q.offer(new int[]{m-1,j});
            }

        }
        bfs(board,q);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='S') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
        
    }
}
