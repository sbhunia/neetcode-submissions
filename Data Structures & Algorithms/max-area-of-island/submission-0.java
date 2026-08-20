class Solution {
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;

        int max_area = 0;
        for(int r=0; r< grid.length; r++)
            for( int c = 0; c<grid[0].length; c++)
                max_area = Math.max(max_area, dfs(r,c));
        return max_area;
    }

    // this method calculates area of an island with DFS
    // by visiting adjacent cells and marking them as visited
    int dfs(int r, int c){
        //First check if the cell is out of the grid boundary
        if(r<0 || r>= grid.length || c<0 || c>=grid[0].length)
            return 0;
        // check if the current cell is water
        if(grid[r][c] == 0)
            return 0;
        
        // that means grid[r][c] is part of land.
        int area = 1;
        grid[r][c] = 0; // marking this cell visited
        // now DFS to all adjacent cells and add the cell counts
        area += dfs(r,c+1);
        area += dfs(r,c-1);
        area += dfs(r-1,c);
        area += dfs(r+1,c);
        return area;
    }
}
