import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/submissions/1550483204/

class Combination_Sum_pick_multiple_times {

    public static void combination(int id,List<Integer> ls,int[] arr,int target,List<List<Integer>> ans){
        int n=arr.length;
        if (id==n) {
            if (target==0) {
                ans.add(new ArrayList<>(ls));
            }
            return;
        }
        if (arr[id]<=target) {
            ls.add(arr[id]);
            combination(id, ls, arr, target - arr[id],ans);
            ls.remove(ls.size()-1);
        }
        combination(id+1, ls, arr, target,ans);
    }

    public static void main(String[] args) {
        int[] arr={2,3,6,7};
        int n=arr.length;
        int target=7;
        List<Integer> ls=new ArrayList<>();
        List<List<Integer>> ans= new ArrayList<>();

        combination(0,ls,arr,target,ans);
        System.out.println(ans);
    }
}