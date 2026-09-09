class Solution {

    /*
        1 2 3 
        4 5 6
        7 8 9

        7 4 1
        8 5 2
        9 6 3


        1 4 7
        2 5 8
        3 6 9

        7 4 1
        8 5 2
        9 6 3

    */


    public void rotate(int[][] matrix) {

        int temp;
        int[] temp1;
        int row = matrix.length;
        int col = matrix[0].length;


        for(int tr = 0,  br = row-1; tr<br; tr++, br--){
            temp1 = matrix[tr];
            matrix[tr]=matrix[br];
            matrix[br] = temp1;
        }



        // Transpose
        for(int r=0; r< row; r++)
            for(int c=0; c<r; c++){
                temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r]=temp;
            }
        // now we need to swap the columns from both end

        // int lc=0;
        // int rc = col-1;
        // while(lc<rc){
        //     for(int r=0; r<row; r++){
        //         temp = matrix[r][lc];
        //         matrix[r][lc] = matrix[r][rc];
        //         matrix[r][rc]=temp;
        //     }
        //     lc++;
        //     rc--;
        // }    




    }
}
