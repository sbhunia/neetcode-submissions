class Solution {

    public static boolean isPair(char opening, char closing){
        return (opening=='(' && closing ==')') 
            || (opening=='{' && closing =='}')
            || (opening=='[' && closing ==']');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i =0; i< s.length(); i++){
            char c  = s.charAt(i);
            
            if(c=='(' || c== '{' || c=='[')
                stack.push(c);
            else if(c==')' || c=='}' || c== ']'){
                if(stack.empty())
                    return false;
                else{
                    char open = stack.pop();
                    if(! isPair(open, c))
                        return false;
                }
            }
        }
        return stack.empty();
    }
}
