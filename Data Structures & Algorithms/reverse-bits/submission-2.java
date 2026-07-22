class Solution {
    /*
    think about checking the i'th bit and setting 31-i 'th bit of result. 
    */
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i<=31; i++){
            if ((n & (1<<i)) !=0){ 
                // i.e. i'th bit of n is 1
                // Now, set the 31-i 'th bit of res to 1
                res += (1<< (31-i));
            }
        }
        return res;
    }
}
