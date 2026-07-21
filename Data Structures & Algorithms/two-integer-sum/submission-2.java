class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for(int i=0; i< nums.length; i++)
            hm.put(nums[i], i);

        for(int i=0; i< nums.length; i++){
            int balance  = target - nums[i];
            if(hm.containsKey(balance)){
                result[0]=i;
                result[1]=hm.get(balance);
                if(result[0]!=result[1])
                    return result;
            }
        }
        return result;
    }
}
