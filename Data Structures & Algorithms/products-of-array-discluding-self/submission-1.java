class Solution {
    /*
    1   2   3   4
    brute foce is O(n^2)

        1   2   3   4
    lr  1   2   6   24 
    rl  24  24  12  4

    mul 24  12  8   6

    */

    public int[] productExceptSelf(int[] nums) {

        int[] lr = new int[nums.length];
        int[] rl = new int[nums.length];

        lr[0] = nums[0];
        for(int i=1; i<nums.length; i++)
            lr[i] = lr[i-1] * nums[i];
        
        rl[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i>=0; i--)
            rl[i] = rl[i+1]* nums[i];
        int[] result = new int[nums.length];
        result[0] = rl[1];
        result[nums.length-1] = lr[nums.length-2];
        for(int i=1; i< nums.length-1; i++)
            result[i] = lr[i-1] * rl[i+1];
        return result;
    }
}  
