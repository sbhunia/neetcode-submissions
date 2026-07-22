class Solution {
    /*
    we can use bitwise XOR operation. 
    first do 0^1^2 .... ^n and store it in res. 
    then chek all the numers in the array and XOR them with res. 
    the final res will be the missing number. 
    */
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i=1; i<=nums.length; i++)
            res = res ^ i;
        for(int i=0; i< nums.length; i++)
            res = res^nums[i];
        return res;
    }
}
