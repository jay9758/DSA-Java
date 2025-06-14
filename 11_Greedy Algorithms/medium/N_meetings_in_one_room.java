//https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class meeting{
    int start;
    int end;
    int pos;

    meeting(int start,int end,int pos){
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}
class meetingComparator implements Comparator<meeting>
{
    @Override
    public int compare(meeting m1,meeting m2){
        if (m1.end<m2.end) {
            return -1;
        }
        else if (m1.end>m2.end) {
            return 1;
        }
        else if (m1.pos<m2.pos) {
            return -1;
        }
        else{
            return 1;
        }
    }
}
public class N_meetings_in_one_room {

    public static int maxMeetings(int[] start,int[] end){
        int n=start.length;
        List<meeting> meet=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meet.add(new meeting(start[i], end[i], i+1));
        }

        meetingComparator mc=new meetingComparator();
        Collections.sort(meet,mc);
        List<Integer> ans=new ArrayList<>();
        int count=1;
        ans.add(meet.get(0).pos);
        int freeTime=meet.get(0).end;

        for (int i = 1; i < n; i++) {
            if (meet.get(i).start > freeTime) {
                count++;
                freeTime= meet.get(i).end;
                ans.add(meet.get(i).pos);
            }
        }
        System.out.println("meeting no: "+ans);
        return count;
    }

    public static void main(String[] args) {
        int[] start={0,3,1,5,5,8};
        int[] end={5,4,2,9,7,9};

        int ans=maxMeetings(start,end);
        System.out.println(ans);
    }
}
