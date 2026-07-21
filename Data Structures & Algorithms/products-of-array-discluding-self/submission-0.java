class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length==0)
            return new int[0];
        // if(nums.length==1){
        //     result = new int[0] ;
        // }
        int[] fMulti = new int[nums.length];
        int[] bMulti = new int[nums.length];
        int[] result = new int[nums.length];

        fMulti[0] = 1;
        for(int i=1; i<nums.length; i++)
            fMulti[i]=fMulti[i-1]*nums[i-1];
        bMulti[nums.length-1] = 1;
        for(int i = nums.length-2; i>=0; i--)
            bMulti[i] = bMulti[i+1]* nums[i+1];
        
        for(int i=0; i< nums.length; i++)
            result[i]=fMulti[i]*bMulti[i];
        return result;

    }
}  
