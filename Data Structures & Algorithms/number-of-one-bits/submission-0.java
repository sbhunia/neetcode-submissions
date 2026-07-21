class Solution {
    /*
    I am thinking of using bitwise and operation.  
    Start with 1 and then shift it right by i bits (for i 0 to 31)
    */

    public int hammingWeight(int n) {
        int count =0;
        for(int i=0; i<32; i++){
            if( (n & (1 <<i)) >0)
                count++;
        }
        return count;
    }
}
