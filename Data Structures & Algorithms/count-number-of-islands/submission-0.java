class Solution {
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int count=0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j);
                }
            }
        return count;
    }
    void dfs(int r, int c){
        if(grid[r][c]=='0')
            return;
        grid[r][c] = '0';
        if(r>0)
            dfs(r-1,c);
        if(r+1<grid.length)
            dfs(r+1,c);
        if(c>0)
            dfs(r,c-1);
        if(c+1<grid[0].length)
            dfs(r,c+1);
    }
}
