class Solution {
    public String longestPalindrome(String s) {
        String maxPal="";
        for(int c=0; c<s.length(); c++){   
            // first check the odd length palindrome. 
            for(int l=c, r=c ; l>=0 && r<s.length(); l--, r++ )
                if(s.charAt(l) == s.charAt(r)){
                    if(r-l+1 > maxPal.length())
                        maxPal=s.substring(l,r+1);
                }
                else
                    break;

            for(int l=c, r=c+1 ; l>=0 && r<s.length(); l--, r++ )
                if(s.charAt(l) == s.charAt(r)){
                    if(r-l+1 > maxPal.length())
                        maxPal=s.substring(l,r+1);
                }
                else
                    break;
        }
        return maxPal;
    }
}
