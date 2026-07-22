class Solution {
    /*
    bitwise operation has to be performed. 

    Start with LSB for each bit, we need to consider the carry forward. 
    s = a ^ b ^ c 
    c = (a & b) | (b & c) | (a & c)
    now forward that carry to next bit and so on.
    */




    public int getSum(int a, int b) {
        
        int c = 0;
        int s = 0;
        for(int i=0; i<32; i++){
            //shift carry to  one position left
            c = c<<1;

            // set the ith bit of s according to the forumula 
            s += (a ^ b ^ c) & (1<<i);  

            // now calculate the carry bit at i 
            c = ((a & b) | (b & c) | (a & c)) & (1<<i);
        }
        if(c !=0){
            s = ~(s ^ 0xFFFFFFFF);
        }
        return s;
    }
}
