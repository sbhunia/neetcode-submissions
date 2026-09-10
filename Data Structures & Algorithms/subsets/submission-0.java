class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int n: nums){
            ArrayList<List<Integer>> tail = new ArrayList<List<Integer>>();
            for(List<Integer> list: result){
                List<Integer> copy = new ArrayList<Integer>(list);
                copy.add(n);
                tail.add(copy);
            }
            result.addAll(tail);
                
            //result.add(new ArrayList<Integer>());
        }
        return result;        
    }
}
