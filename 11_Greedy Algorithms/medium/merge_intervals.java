//https://leetcode.com/problems/merge-intervals/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_intervals {

    public static int[][] mergeInterval(int[][] interval){
        List<int[]> res=new ArrayList<>();
        if (interval.length==0 || interval==null) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(interval,(a,b)->a[0]-b[0]);
        int start=interval[0][0];
        int end=interval[0][1];

        int[] ans={};
        
        for (int[] i : interval) {
            if (i[0]<=end) {
                end=Math.max(end, i[1]);
            }
            else{
                res.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        int[][] interval={{1,3},{2,6},{8,10},{8,9},{9,11},{15,18},{2,4},{16,17}};

        int[][] ans=mergeInterval(interval);
        System.out.println(Arrays.deepToString(ans));
    }
}
