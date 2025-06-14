//https://leetcode.com/problems/subsets/submissions/1557949118/

import java.util.ArrayList;
import java.util.List;


public class Power_Set {

    public static void subsets(int[] arr,int subsets,List<List<Integer>> ans){
        int n=arr.length;
        for (int i = 0; i < subsets; i++) {
            List<Integer> ls=new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1<<j)) != 0) {
                    ls.add(arr[j]);
                }
            }
            ans.add(ls);
        }
    }
    public static void main(String[] args) {
        int[] arr={1,2,3};
        int n=arr.length;

        int subsets=1<<n;

        List<List<Integer>> ans=new ArrayList<>();
        subsets(arr,subsets,ans);
        System.out.println(ans);
    }
}
