class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int n:nums)
            hs.add(n);
        int maxLen = 0;
        for(int n: nums){
            if(!hs.contains(n-1)){ //i.e. n is start of a sequence
                int len = 0;
                while(hs.contains(n+len))
                    len++;
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }
}
