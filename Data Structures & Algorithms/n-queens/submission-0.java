class Solution {
    char[][] board;
    List<List<String>> result = new ArrayList<>();

    boolean validPosition(int r, int c){
        //considering previous rows are filled. we neeed to consider 
        // previous rows in 3 directions. up, up-left and up-right
        //first check up direction
        for(int i=r-1; i>=0; i--){
            if(board[i][c] =='Q')
                return false;
        }
        //now check upleft
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] =='Q')
                return false;
        }
        //now check up right
        for(int i=r-1, j=c+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] =='Q')
                return false;
        }
        return true;
    }
    void backtrack(int row){
        if(row>=board.length){
            //solution reached
            List<String> list = new ArrayList<>();
            for(char[] charArray: board)
                list.add(new String(charArray));
            result.add(list);
            return;
        }
        for(int c =0; c< board.length; c++){
            if(validPosition(row, c)){
                board[row][c]='Q';
                backtrack(row+1);
                board[row][c]='.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];  
        for(int r=0; r<n; r++)
            for(int c=0; c<n; c++)
                board[r][c]='.';
        backtrack(0);
        return result;
    }
}
