class Solution {
    public boolean isValid(char[][] board, int row, int col){
        for(int r = 0; r<row; r++){
            if(board[r][col]=='Q') return false;
        }
        int r = row-1;
        int c = col-1;
        while(r>=0 && c>=0){
            if(board[r][c]=='Q') return false;
            r--;
            c--;
        }
        r = row-1;
        c = col+1;
        while(r>=0 && c<board.length){
            if(board[r][c]=='Q') return false;
            r--;
            c++;
        }
        return true;
    }
    public int countQueen(char[][] board, int row, int n){
        if(row==n){
            
            return 1;
        }
        int count = 0;
        for(int col=0;col<n;col++){
            if(isValid(board, row, col)){
                board[row][col] = 'Q';
                count+=countQueen(board, row+1, n);
                board[row][col] = '.';

            }
        }
        return count;

    }
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        return countQueen(board, 0,n);

        
    }
}