class Solution {
    public int climbStairs(int n) {
        if(n<=1)
            return 1;

        int fn_1 = 2;
        int fn_2 = 1;

        for(int i=3; i<=n; i++){
            int fn = fn_1 + fn_2;
            fn_2=fn_1;
            fn_1=fn;
        }
        return fn_1;
    }
}
