class Solution {
    /*
    1   2   3   4
    brute foce is O(n^2)

        1   2   3   4
    lr  1   1   2   6   
    rl  24  12  4   1

    mul 24  12  8   6

    */

    public int[] productExceptSelf(int[] nums) {

        int[] lr = new int[nums.length];
        int[] rl = new int[nums.length];

        lr[0] = 1;
        for(int i=1; i<nums.length; i++)
            lr[i] = lr[i-1] * nums[i-1];
        
        rl[nums.length-1] = 1;
        for(int i = nums.length-2; i>=0; i--)
            rl[i] = rl[i+1]* nums[i+1];
        int[] result = new int[nums.length];
        
        for(int i=0; i< nums.length; i++)
            result[i] = lr[i] * rl[i];
        return result;
    }
}  
