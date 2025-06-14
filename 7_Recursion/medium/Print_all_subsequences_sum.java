//https://www.youtube.com/watch?v=eQCS_v3bw0Q&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=7

import java.util.ArrayList;

public class Print_all_subsequences_sum {
    public static void subsequence(int id,ArrayList<Integer> ls,int[] arr,int s,int sum,int n) {
        if (id==n) {
            if (s==sum) {
                System.out.println(ls);
            }
            return;
        }
        
        ls.add(arr[id]);
        s=s+arr[id];
        subsequence(id+1, ls, arr, s, sum, n);

        ls.remove(ls.size()-1);
        s=s-arr[id];
        subsequence(id+1, ls, arr, s, sum, n);
    }
    public static void main(String[] args) {
        int[] arr={1,2,1};
        int n=arr.length;
        int sum=2;
        ArrayList<Integer> ls= new ArrayList<>();

        subsequence(0,ls,arr,0,sum,n);
    }
}
