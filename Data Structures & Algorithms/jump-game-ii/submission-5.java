class Solution {
    /*
    sliding window protocol
    l,r. l is the starting ris the range. start both as 0
    then you go from lto r and see what would be the new range.
    then make l=r+1, r=range. at each window iteration jump++
    */
    public int jump(int[] nums) {
        int l=0,r=0, jump=0;
        while(r<nums.length-1){ // sliding window itration
            int range =l;
            while(l<=r){ // checking all index from l to r
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
