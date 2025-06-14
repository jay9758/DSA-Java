//optimal
//https://leetcode.com/problems/combination-sum-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination_Sum_unique2 {
    public static void combination(int id,List<Integer> ls,int[] arr,int target,Set<List<Integer>> ans){
        int n=arr.length;
            if (target==0) {
                ans.add(new ArrayList<>(ls));
                return;
            }
        for (int i = id; i < n; i++) {
            if (i>id && arr[i]==arr[i-1]) {
                continue;
            }
            if (arr[i]>target) {
                break;
            }
            ls.add(arr[i]);
            combination(i+1, ls, arr, target - arr[i],ans);
            ls.remove(ls.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,2,2};
        int n=arr.length;
        int target=4;
        Arrays.sort(arr);
        List<Integer> ls=new ArrayList<>();
        Set<List<Integer>> ans= new HashSet<>();

        combination(0,ls,arr,target,ans);
        System.out.println(ans);
    }
}

