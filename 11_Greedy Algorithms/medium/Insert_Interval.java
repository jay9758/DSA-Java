//https://leetcode.com/problems/insert-interval/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert_Interval {

    public static List<List<Integer>> insertInterval(int[][] interval,int[] newinterval){
        int n=interval.length;
        int[] ans={};
        List<List<Integer>> res=new ArrayList<>();
        int i=0;
        while (i<n && interval[i][1]<newinterval[0]) {
            res.add(Arrays.asList(interval[i][0],interval[i][1]));
            i++;
        }
        while (i<n && interval[i][0]<=newinterval[1]) {
            newinterval[0]=Math.min(newinterval[0], interval[i][0]);
            newinterval[1]=Math.max(newinterval[1], interval[i][1]);
            i++;
        }
        res.add(Arrays.asList(newinterval[0],newinterval[1]));
        while (i<n) {
            res.add(Arrays.asList(interval[i][0],interval[i][1]));
            i++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] interval={{1,3},{4,5},{6,7},{8,10}};
        int[] newinterval={5,6};

        List<List<Integer>> ans=insertInterval(interval,newinterval);
        System.out.println(ans);
    }
}
