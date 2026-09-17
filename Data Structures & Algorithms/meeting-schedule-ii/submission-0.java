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

 /* We need multiple rooms. Add first meeting to a room.
 Add this to priority queue. Priority is based on ending time.
 when adding a new meeting we check if any room has meeting ended then add the meeting to that room.
 if no rrom free then add a new room
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int [] s = new int[intervals.size()];
        int [] e = new int[intervals.size()];

        for(int i=0; i< intervals.size(); i++){
            s[i] = intervals.get(i).start;
            e[i] = intervals.get(i).end;
        }
        Arrays.sort(s);
        Arrays.sort(e);

        int maxRoom=0;
        
        int si=0, ei=0, curRoom=0;
        while(si<intervals.size() && ei<intervals.size()){
            if(s[si] < e[ei] ){//another meeting starting
                curRoom++;
                maxRoom = Math.max(curRoom, maxRoom); 
                si++;
            } else{
                curRoom--;
                ei++;
            }
        }
        return maxRoom;
    }
}
