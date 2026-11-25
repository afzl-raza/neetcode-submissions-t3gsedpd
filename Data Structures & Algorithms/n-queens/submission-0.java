class Solution {
    public boolean isValid(char[][] board, int row, int col){
        for(int r=0;r<row;r++){
            if(board[r][col] == 'Q') return false;
        }
        int r = row-1;
        int c = col-1;
        // Moving towards the left diagonal...
        while(r>=0 && c>=0){
            if(board[r][c]=='Q') return false;
            r-=1;
            c-=1;
        }
        r = row-1;
        c = col+1;
        while(r>=0 && c<board.length){
            if(board[r][c]=='Q') return false;
            r-=1;
            c+=1;
        }
        return true;
    }
    public List<String> convert(char[][] board,int n){
        List<String> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new String(board[i]));
        }
        return ans;
    }
    public void placeQueen(char[][] board, int row, int n,List<List<String>> ans ){
        if(row==n){
            List<String> a = convert(board,n);
            ans.add(a);
        }
        for(int col=0;col<n;col++){
            if(isValid(board,row,col)){
                board[row][col] = 'Q';
                placeQueen(board, row+1,n,ans);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        placeQueen(board,0,n,ans);
        return ans;


        
    }
}
