//https://www.geeksforgeeks.org/problems/subset-sums2234/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=subset-sums

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Subset_Sum_1 {
    public static void subsetsSum(int id,int[] arr,int sum,List<Integer> ls){
        int n=arr.length;
        
        if (id==n) {
            ls.add(sum);
            return;
        }

        subsetsSum(id+1, arr, sum+arr[id],ls);
        subsetsSum(id+1, arr, sum,ls);
    }
    public static void main(String[] args) {
        int[] arr={3,1,2};
        int n=arr.length;
        int sum=0;
        List<Integer> ls=new ArrayList<>();

        subsetsSum(0,arr,sum,ls);
        Collections.sort(ls);
        System.out.println(ls);
    }
}
