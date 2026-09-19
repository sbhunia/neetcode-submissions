class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalDiff=0, curDiff=0;
        int start = 0;
        for(int i=0; i<gas.length; i++){
            totalDiff += gas[i]-cost[i];
            if(curDiff<0){
                curDiff = 0;
                start = i;
            }
            curDiff+= gas[i]-cost[i];
        }
        if(totalDiff<0)
            return -1;
        else    
            return start;
    }
}
