class Solution {
    /*
    [2,5,6,9] 

    9 -> 7 4 3 0

    7 -> 5 2 1 -2 

    5 -> 3, 0 -1 -4

    2 -> 0 -3 -4 -7

    1 -> -1 -4 -5 -8

    3 -> 1 -2 -3 -6
    4 -> 
    */

    int [] nums;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        backtrack(target, 0, new ArrayList<>()); // send empty path 

        return new ArrayList<>(result);  
    }

    void backtrack(int target, int index, List<Integer> path){
        if(target ==0) // a valid combination found. put the path
            result.add(new ArrayList(path));
        else if(target<0) //no combinationation possible. backtrack
            return;
        else if(index >=nums.length) // nums got exhausted. Backtrack
            return;
        else{
            path.add(nums[index]); // add the nums[i] to path and DFS
            backtrack(target-nums[index], index, path);
            path.remove(path.size()-1); // remove the nums[i] after backtrack
            // not DFS with next index
            backtrack(target, index+1, path);
        }
    }
}
