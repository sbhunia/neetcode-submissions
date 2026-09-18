class Solution {

    int compare(int[] a, int[] b){
        return   (b[0]*b[0]+ b[1]*b[1])-(a[0]*a[0]+ a[1]*a[1]);
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b)->compare(a,b)
        );
        
        for(int[] p: points){
            if(maxHeap.size()<k) //if size less than k then add it
                maxHeap.add(p);
            else if(compare(p, maxHeap.peek())>0){
                //chck if p is shorter than the maxheap max
                maxHeap.poll();
                maxHeap.add(p);
            }
            
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
