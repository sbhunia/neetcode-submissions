class Solution {
    /*
    1   2   3   4   5   6   7   8

    1 rotation
    8   1   2   3   4   5   6   7

    4 rotation

    5   6   7   8   1   2   3   4

    find minimum. 
    
    */

    public int findMin(int[] nums) {

        int l =0;
        int r = nums.length-1;

        while( l <=r ){
            if(nums[l] <= nums[r])
                return nums[l];
            
            int m = (l+r)/2;
            if(nums[l]>nums[m])
                r=m;
            else
                l=m+1;
        }
        return -1;
    }
}
