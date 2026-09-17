class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,Map<Integer,Integer>>  adjMap = 
            new HashMap<>();

        Map<Integer, Integer> distMap = new HashMap<>();

        for(int i=1; i<=n; i++){
            adjMap.put(i, new HashMap<>()); 
            distMap.put(i, Integer.MAX_VALUE);
        }
        
        for(int[] edge: times){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            (adjMap.get(u)).put(v,t);
        }

        distMap.put(k,0); // putting source node time to 0

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
            (a, b) -> Integer.compare(distMap.get(a),distMap.get(b)));

        heap.add(k);

        while(! heap.isEmpty()){
            int minNode = heap.poll();
            Map<Integer,Integer> map = adjMap.get(minNode);

            for(int v: map.keySet()){
                int t = map.get(v);

                if(distMap.get(v) > distMap.get(minNode)+t){
                    distMap.put(v, distMap.get(minNode)+t);
                    if(!heap.contains(v))
                        heap.add(v);
                }
            }
        }
        int maxTime=0;
        for(int v: distMap.keySet()){
            if(distMap.get(v) == Integer.MAX_VALUE)
                return -1;
            else if(maxTime<distMap.get(v))
                maxTime = distMap.get(v);
        }
        return maxTime;
    }
}
