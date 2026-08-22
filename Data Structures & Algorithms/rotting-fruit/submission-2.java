class Solution {
    int[][] grid;
    ArrayDeque<int[]> queue = new ArrayDeque();
    int max_minute=0;
    public int orangesRotting(int[][] grid) {
        this.grid = grid;

        for(int r =0; r<grid.length; r++)
            for(int c=0; c<grid[0].length; c++)
                if(grid[r][c]==2) // rotten fruit
                    queue.addLast(new int[]{r,c});
        
        bfs();
        
        for(int r =0; r<grid.length; r++)
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c]==1) // i.e. the cell has a fresh fruit
                    return -1; 
            }
        return max_minute;        
    }
    void rotten(int r, int c, int distance){
        if(r<0 || r>= grid.length
            || c<0 || c>=grid[0].length)
            return;
        if(grid[r][c]==1){
            grid[r][c]=distance;
            int minutes = distance-2;
            max_minute = max_minute>minutes? max_minute : minutes;
            queue.addLast(new int[]{r,c});
        }


    }
    void bfs(){
        while(!queue.isEmpty()){
            int[] cell = queue.removeFirst();
            int r = cell[0];
            int c = cell[1];
            //if(if(grid[r][c]==2))
            rotten(r-1,c, grid[r][c]+1);
            rotten(r+1,c, grid[r][c]+1);
            rotten(r,c-1, grid[r][c]+1);
            rotten(r,c+1, grid[r][c]+1);
        }   
    }
}
