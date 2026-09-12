class KthLargest {
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n: nums)
            this.add(n);
    }
    
    public int add(int val) {
        if(minheap.size() < k)
            minheap.add(val);
        else if(minheap.peek() < val){
            minheap.poll();
            minheap.add(val);
        }
        return minheap.peek();
    }
}
