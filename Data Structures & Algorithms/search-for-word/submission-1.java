class Solution {
    int col;
    int row;
    char[][] board;
    String word;
    private boolean exist(int r, int c, int wi){
        if(wi>=word.length())
            return true;
        if(r<0 || r>=row || c<0 || c>=col)
            return false;
        char x = board[r][c];
        if( board[r][c] != word.charAt(wi) )
            return false;
        board[r][c] = '*';
        boolean result = exist(r-1, c, wi+1) 
                || exist(r+1, c, wi+1) 
                || exist(r, c-1, wi+1)
                || exist(r, c+1, wi+1);
        board[r][c]=x;
        return result;
    }


    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        row = board.length;
        if(row==0)
            return false;
        col = board[0].length;
        if(col==0)
            return false;
        if(word.length()==0)
            return false;
        for(int r=0; r<row; r++)
            for(int c=0; c<col; c++)
                if(exist(r,c,0))
                    return true;
        return false;  
    }
}
