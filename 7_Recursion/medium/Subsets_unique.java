//brute
//https://leetcode.com/problems/subsets-ii/submissions/1550656343/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Subsets_unique {
    public static void subsets(int id,int[] arr,List<Integer> sub,Set<List<Integer>> ls){
        int n=arr.length;
        
        if (id==n) {
            ls.add(new ArrayList<>(sub));
            return;
        }

        sub.add(arr[id]);
        subsets(id+1, arr, sub,ls);

        sub.remove(sub.size()-1);
        subsets(id+1, arr, sub,ls);
    }
    public static void main(String[] args) {
        int[] arr={1,2,2};
        int n=arr.length;
        Arrays.sort(arr);
        List<Integer> sub=new ArrayList<>();
        Set<List<Integer>> ls=new HashSet<>();

        subsets(0,arr,sub,ls);
        System.out.println(ls);
    }
}
