class Solution {
    /*
    A   A   A   B   A   B   B

    l=0, r = 2,   {A=3}, length = 3, replacement =0

    l=0, r= 3, {A=3,B=1}, length =4 replacement = 1

    l=0, r= 4, {A=4,B=1}, length =5 replacement = 1

    l=0, r= 5, {A=4,B=2}, length =5 replacement = 2 
    



    */


    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int [] cFreq = new int[26];
        int l=0,r=0;
        while(r<s.length()){
            cFreq[s.charAt(r)-'A']++; // add the right char to cFreq
            while(l<=r){
                // sliding window is from l to r.
                int length = r-l+1;
                int max_freq = 0;
                for(int i=0; i<26; i++)
                    if(cFreq[i]>max_freq)
                        max_freq = cFreq[i];
                if(length<=k+max_freq){ // valid replacement
                     if(maxLength<length)
                        maxLength = length;
                    break;
                } else{
                    cFreq[s.charAt(l)-'A'] --;
                    l++;
                }
            }
            r++;
        }
        return maxLength;
    }
}
