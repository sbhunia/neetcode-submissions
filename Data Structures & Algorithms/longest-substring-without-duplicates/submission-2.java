class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int l = 0;
        int r = 0;

        HashSet<Character> hs = new HashSet<Character>();
        while (r<s.length()){
            if(hs.contains(s.charAt(r))){
                while(s.charAt(l)!=s.charAt(r)){
                    hs.remove(s.charAt(l));
                    l++;
                }
                l++;
            } else{
                hs.add(s.charAt(r));
                maxLen = Math.max(maxLen, hs.size());
            }
            r++;
        }
        return maxLen;
    }
}
