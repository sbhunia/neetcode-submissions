class Solution {

    /*
    */
    public int minEatingSpeed(int[] piles, int h) {

        int max= piles[0];
        int min = 1;//piles[0];
        for(int p: piles){
            max = Math.max(max, p);
            //..min = Math.min(min, p);
        } 
        //binary search
        while(min<max){
            int mid = min + (max - min)/2;
            
            //asume mid as k now check how many hours it would take
            int hours = 0;
            for(int p: piles)
                hours+=Math.ceilDiv(p,mid);
            if(hours<=h){ // this k is valid. try to lower window 
                max= mid;
            } else{
                //that means this mid can not support. higher window
                min = mid+1;
            }       
        }
        return max;  
    }
}
