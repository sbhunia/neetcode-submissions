class Solution {
    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length-1;

        while(l<r && nums[l] > nums[r]){
            int mid = (l+r)/2;
            if(nums[l]<= nums[mid])
                l=mid+1;
            else
                r=mid;
        }
        return nums[l];

    }
}
