class Solution {
    /*
    HashMap that contains length of 
    */



    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int n: nums)
            hs.add(n);
        int maxCount =0;
        for(int n: nums){
            //check if n-1 exists in the set. Then it is not the starter
            if(!hs.contains(n-1)){
                int count =1;
                for(int i= n+1; hs.contains(i); i++)
                    count++;
                if(count>maxCount)
                    maxCount=count;
            }
                
        }
        return maxCount;
    }
}
