/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

 /*
 asume a sorted array
 a1,b1  a2,b2   a3,b3
 a2>=b1
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b)-> Integer.compare(a.start, b.start));

        for(int i=1; i< intervals.size(); i++)
            if(intervals.get(i).start < intervals.get(i-1).end) //overlap
                return false;
        return true;

    }
}
