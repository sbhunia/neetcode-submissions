class Solution {
    public int rob(int[] nums) {
        if(nums.length<=1)
            return nums[0];
        int[] max_first = new int[nums.length];
        int[] max_second = new int[nums.length];


        max_first[0] = nums[0];
        max_first[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length-1; i++)
            max_first[i] = Math.max(nums[i]+max_first[i-2], max_first[i-1]);
        
        max_second[0] = 0;
        max_second[1] = nums[1];
        for(int i=2; i<nums.length; i++)
            max_second[i] = Math.max(nums[i]+max_second[i-2], max_second[i-1]);

        return Math.max( max_second[nums.length-1], max_first[nums.length-2] );
    }
}
