class Solution {
    // The idea is that I'll do DFS from edge cells containing 0. 
    // Mark those adjacent O cells as visited
    // afterwords whichever cells have O and markd as O they are not surrounded
    // all other O can not be reached from border, 
    // so, they are surrounded. So, they would be converted to X.

    char board[][];
    boolean [][] visited;
    int ROW, COL;
    public void solve(char[][] board) {
        this.board=board;
        ROW= board.length;
        COL = board[0].length;
        visited = new boolean[ROW][COL];
        
        for(int r=0; r<ROW; r++){
            dfs(r,0);
            dfs(r, COL-1);
        }
        for (int c=0; c<COL; c++){
            dfs(0,c);
            dfs(ROW-1,c);
        }
        for(int r=0; r<ROW; r++)
            for(int c=0; c<COL; c++)
                if(!visited[r][c])
                    board[r][c]='X';
    }
    void dfs(int r, int c){
        if(r<0 || c<0 || r>=ROW || c>=COL)
            return;
        if(visited[r][c])
            return;
        visited[r][c] = true;
        if(board[r][c]=='O'){ 
            // that means this cell could be reached from border
            dfs(r-1,c);
            dfs(r+1,c);
            dfs(r,c-1);
            dfs(r,c+1);
        }
    }
}
