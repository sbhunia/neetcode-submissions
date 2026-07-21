class Solution {
    public int rob(int[] nums) {
        int [] max_money = new int[nums.length];
        if(nums.length==1)
            return nums[0];
        max_money[0] = nums[0];
        max_money[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++)
            max_money[i] = Math.max(max_money[i-1], max_money[i-2]+nums[i]);
        return max_money[nums.length-1];
    }
}
