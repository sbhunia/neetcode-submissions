class Solution {

    /*
    Explanation:
        0 --> 0.   -> 0
        1 --> 1.   -> 1
        2 --> 10.  -> 1
        3 --> 11.  -> 2
        4 --> 100  -> 1
        5 --> 101. -> 2
        6 --> 110  -> 2
        7 --> 111. -> 3
        8 --> 1000.-> 1

        
        dp[0]=0;
        start with offset of 1 and iterate through the numbers. 
        Every time ofset is reached , double ofset 
        dp[i] = 1 + dp[i - offset]
    */

    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        int offset =1;
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            if(i==offset*2)
                offset*=2;
            dp[i] = 1+ dp[i-offset]; 
        }
        return dp;
    }
}
