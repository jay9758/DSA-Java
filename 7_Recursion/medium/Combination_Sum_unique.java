//brute

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination_Sum_unique {
    public static void combination(int id,List<Integer> ls,int[] arr,int target,Set<List<Integer>> ans){
        int n=arr.length;
        if (id==n) {
            if (target==0) {
                ans.add(new ArrayList<>(ls));
            }
            return;
        }
        if (arr[id]<=target) {
            ls.add(arr[id]);
            combination(id+1, ls, arr, target - arr[id],ans);
            ls.remove(ls.size()-1);
        }
        combination(id+1, ls, arr, target,ans);
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,2,2};
        int n=arr.length;
        int target=4;
        List<Integer> ls=new ArrayList<>();
        Set<List<Integer>> ans= new HashSet<>();

        combination(0,ls,arr,target,ans);
        System.out.println(ans);
    }
}
