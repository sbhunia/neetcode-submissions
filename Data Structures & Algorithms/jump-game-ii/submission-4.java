class Solution {
    /*
    sliding window protocol
    */
    public int jump(int[] nums) {
        int l=0,r=0, jump=0;
        while(r<nums.length-1){
            int range =l;
            while(l<=r){
                range = Math.max(range, l+nums[l]);
                l++;
            }
            l=r+1;
            r=range;
            jump++;
        }
        return jump;
    }
}
