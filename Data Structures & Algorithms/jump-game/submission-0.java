class Solution {
    /*
    at each index, i'll get a range for jump.
    I'll keep a max range from that point.
    if max range reaches n-1, then we are done.
    however, if we rach to point i>range, then we can not reach the last


    */
    public boolean canJump(int[] nums) {
        int r=0;
        for(int l=0; l<nums.length-1 && l<=r; l++){
            r = Math.max(r, l+nums[l]);
        }
        return (r>=nums.length-1);
    }
}
