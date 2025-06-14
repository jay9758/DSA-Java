//code is different because of input
//https://leetcode.com/problems/non-overlapping-intervals/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class interval{
    int start;
    int end;
    int pos;

    interval(int start,int end,int pos){
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
    public String toString(){
        return "("+start+","+end+")";
    }
}
class intervalComparator implements Comparator<interval>
{
    @Override
    public int compare(interval m1,interval m2){
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
public class Non_overlapping_Intervals {

    public static int eraseOverlapInterval(int[] start,int[] end){
        int n=start.length;
        List<interval> inter=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inter.add(new interval(start[i], end[i], i+1));
        }
        
        intervalComparator mc=new intervalComparator();
        Collections.sort(inter,mc);
        List<Integer> ans=new ArrayList<>();
        int count=1;
        ans.add(inter.get(0).pos);
        int lastEndTime=inter.get(0).end;

        for (int i = 1; i < n; i++) {
            if (inter.get(i).start >= lastEndTime) {
                count++;
                lastEndTime= inter.get(i).end;
                ans.add(inter.get(i).pos);
            }
        }
        System.out.println("interval no: "+ans);
        return n - count;
    }

    public static void main(String[] args) {
        int[] start={0,3,1,5,5,7};
        int[] end={5,4,2,9,7,9};

        int ans=eraseOverlapInterval(start,end);
        System.out.println(ans);
    }
}
