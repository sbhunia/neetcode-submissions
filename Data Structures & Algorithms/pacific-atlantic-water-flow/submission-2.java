class Solution {
    int [][] heights;
    int ROW, COL;
    boolean [][] pacific;
    boolean [][] atlantic;
    final int UNCHARTED = 2;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights=heights;
        ROW = heights.length;
        COL= heights[0].length;

        pacific = new boolean[ROW][COL];
        atlantic = new boolean[ROW][COL];
        for(int r=0; r<heights.length; r++)
            for(int c=0; c<heights[0].length; c++){
                pacific[r][c]=false;
                atlantic[r][c]=false;            
            }
        // Start from border cells and then do DFS to mark cells
        // that can have flow to the border
        for(int r=0; r<ROW; r++){
            dfs(r, 0, pacific);
            dfs(r, COL-1, atlantic);
        }
        for(int c=0;c<COL; c++){
            dfs(0, c, pacific);
            dfs(ROW-1, c, atlantic);
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int r=0; r<heights.length; r++)
            for(int c=0; c<heights[0].length; c++){
                if(atlantic[r][c] && pacific[r][c]){
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(r);
                    cell.add(c);
                    list.add(cell);
                }
            }    
        return list;
    }
    void dfs(int r, int c, boolean[][] ocean){
        // if you are on this cell that means this cell
        // has a flow to ocean. So, the ocean flow as true
        if(ocean[r][c])
            return;
        ocean[r][c]=true;
        // now look at adjacent cells and if the adjacent 
        // cell sits higher then mark that ocean as well  
        if(r>0 && heights[r-1][c]>=heights[r][c])
            dfs(r-1,c,ocean);
        if(c>0 && heights[r][c-1]>=heights[r][c])
            dfs(r, c-1, ocean);
        if(r<ROW-1 && heights[r+1][c] >=heights[r][c])
            dfs(r+1, c, ocean);
        if(c<COL-1 && heights[r][c+1] >= heights[r][c])
            dfs(r, c+1, ocean);
    }
}
