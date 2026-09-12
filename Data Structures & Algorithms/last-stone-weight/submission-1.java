class Solution {
    PriorityQueue<Integer> maxHeap;
    public int lastStoneWeight(int[] stones) {
        maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int s: stones)
            maxHeap.add(s);
        
        while(maxHeap.size()>1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            // if x and y same then discard them.
            if(y!=x)
                // we know y >x. So, reinsert y-x
                maxHeap.add(y-x);
        }
        if(maxHeap.size()>0)
            return maxHeap.peek();
        else
            return 0;
    }
}
