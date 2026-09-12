class Solution {
    /*
    get count for each number into a hashmap

    */




    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            int count = 1;
            if(map.containsKey(n))
                count+= map.get(n);
            map.put(n, count);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int n: map.keySet()){
            if(minHeap.size()<k)
                minHeap.add(n);
            else if(map.get(minHeap.peek()) < map.get(n)){
                minHeap.poll();
                minHeap.add(n);
            }
        }
        int [] result = new int[k];
        for(int i =0; i<k; i++)
            result[i] = minHeap.poll();
        return result;


    }
}
