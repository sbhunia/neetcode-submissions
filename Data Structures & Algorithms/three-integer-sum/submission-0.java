class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();

        Arrays.sort(nums);
        for (int i=0; i< nums.length - 2; ){
            int l = i+1;
            int r = nums.length - 1;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if( sum == 0){
                    List<Integer> al = new ArrayList<Integer>();
                    al.add(nums[i]);
                    al.add(nums[l]);
                    al.add(nums[r]);
                    result.add(al);
                    l++;
                    while(l<r && nums[l]==nums[l-1])
                        l++;
                    r--;
                    while(l<r && nums[r] == nums[r+1])
                        r--;
                } else if(sum>0)
                    r--;
                else
                    l++;
            }
            i++;
            while(i< nums.length - 2 && nums[i]==nums[i-1])
                i++;
        }
        return result;
    }
}
