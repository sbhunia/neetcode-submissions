class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        /*

        1   2   3   4
        5   6   7   8  
        9   10  11  12

        */

        ArrayList<Integer> list = new ArrayList<Integer>();
        int colL=0, colH=col-1, rowL=0, rowH=row-1;
        while(colL<=colH && rowL<=rowH){
            for(int i=colL; i<=colH; i++)
                list.add(matrix[rowL][i]);
            for(int i = rowL+1; i<= rowH; i++)
                list.add(matrix[i][colH]);
            if(rowL!=rowH)
                for(int i=colH-1; i>=colL; i--)
                    list.add(matrix[rowH][i]);
            if(colL!=colH)
                for(int i= rowH-1; i>=rowL+1; i --)
                    list.add(matrix[i][colL]);

            colL++;
            colH--;
            rowL++;
            rowH--;
        }
        return list;
    }
    
}
