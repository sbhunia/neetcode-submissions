class Solution {
    int [][] grid;
    static final int UNCHARTERED = -1;

    public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0)
            return 0;
        grid = new int[m][n];
        for(int i=0; i<m; i++) 
            for(int j=0; j<n; j++)
                grid[i][j] = UNCHARTERED;
        grid[m-1][n-1] = 1;    

        return getPathCount(0,0);  
    }
    int getPathCount(int r, int c){
        if(r >= grid.length || c>= grid[0].length)
            return 0;

        if(grid[r][c]!=UNCHARTERED)
            return grid[r][c];
        
        grid[r][c] = getPathCount(r, c+1) + getPathCount(r+1, c);
        return grid[r][c];
    }

}
