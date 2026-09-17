class Solution {
    /*
    valid row
    valid column
    valid square
    for checking, take a boolean array with 9 element. make a[i]=true if i exists. before making true, if it is already tru then return false;
    */

    char[][] board;
    boolean validRow(int r){
        boolean[] nums = new boolean[10];
        for(int c=0; c<9; c++){
            if(board[r][c]!='.'){
                int n = board[r][c] - '0';
                if(nums[n]) //number already marked
                    return false;
                nums[n] = true;
            }
        }
        return true;
    }
    boolean validCol(int c){
        boolean[] nums = new boolean[10];
        for(int r=0; r<9; r++){
            if(board[r][c]!='.'){
                int n = board[r][c] - '0';
                if(nums[n]) //number already marked
                    return false;
                nums[n] = true;
            }
        }
        return true;
    }
    boolean validSquare(int row, int col){
        boolean[] nums = new boolean[10];
        for(int r=row; r<row+3; r++){
            for(int c=col; c< col+3; c++){
                if(board[r][c]!='.'){
                    int n = board[r][c] - '0';
                    if(nums[n]) //number already marked
                        return false;
                    nums[n] = true;
                }
            }
        }
        return true;
    }


    public boolean isValidSudoku(char[][] board) {
        this.board = board;

        for(int i=0; i<9; i++){
            if(! validRow(i))
                return false;
            if(! validCol(i))
                return false;
            // now for square
        }
        for(int r=0; r<9; r+=3)
            for(int c =0; c<9; c+=3)
                if(!validSquare(r,c))
                    return false;
        return true;
    }
}
