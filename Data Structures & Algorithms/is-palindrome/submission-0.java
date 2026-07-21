class Solution {

    private boolean isAlph(char c){
        return (c>='a' && c <='z') || (c>='A' && c<='Z') || (c>='0' && c<='9');
    }

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length()-1;

        do{
            while( (left< right) && (!Character.isLetterOrDigit(s.charAt(left))))
                left++;
            while((right>left) && (!Character.isLetterOrDigit(s.charAt(right))))
                right--;
            
            if(left < right){
                if(Character.toUpperCase(s.charAt(left)) != 
                        Character.toUpperCase(s.charAt(right)) )
                    return false;
            }
            left++;
            right--;
        } while(left<right);

        return true;
    }
}
