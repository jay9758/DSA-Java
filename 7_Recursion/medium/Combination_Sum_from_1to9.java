//https://leetcode.com/problems/combination-sum-iii/

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_from_1to9 {

    public static void combination(int i,int len,List<Integer> temp,int sum,int target,List<List<Integer>> ans){
        if (temp.size()==len && sum==target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (sum>target || i>9) {
            return;
        }
        temp.add(i);
        combination(i+1, len, temp, sum+i, target, ans);
        temp.remove(temp.size()-1);
        combination(i+1, len, temp, sum, target, ans);
    }
    public static void main(String[] args) {
        int k=3; //size
        int n=7; //sum
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        combination(1, k, temp, 0, n,ans);

        System.out.println(ans);
    }
}
