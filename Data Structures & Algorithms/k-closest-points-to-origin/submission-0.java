class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b)->Integer.compare( (b[0]*b[0]+ b[1]*b[1]), (a[0]*a[0]+ a[1]*a[1]))
        );
        
        for(int[] p: points){
            maxHeap.add(p);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        int[][] result = new int[k][2];
        for(int i=0; i<k; i++){
            if(!maxHeap.isEmpty()){
                int[] p = maxHeap.poll();
                result[i][0] = p[0];
                result[i][1] = p[1];
            }
        }
        return result;

    }
}
