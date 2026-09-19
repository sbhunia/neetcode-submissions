class Solution {
    /*
    sliding window and greedy 
    nums    [1,2,-1,-2,2,1,-2,1,4,-5,4]
    cur_sum [1,3, 2, 0,2,3, 1,2,6, 1,5]




    */


    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int n: nums){
            if(curSum<0)
                curSum=0;
            curSum+=n;
            maxSum=Math.max(curSum,maxSum);
        }
        return maxSum;
    }
}
