class Solution {
    /*
    HashMap , key = a[i], value = i
    */


    public int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++)
            hm.put(nums[i], i);
        for(int j =0; j<nums.length; j++){
            int x = target-nums[j];
            if(hm.containsKey(x)){
                int i = hm.get(x);
                if(i != j){
                    if(i<j){
                        result[0] = i;
                        result[1] = j;
                    }
                    else{
                        result[0]=j;
                        result[1]=i;
                    }
                    
                }
            }
                         
        }
        return result;
    }
}
