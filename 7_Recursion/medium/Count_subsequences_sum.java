import java.util.ArrayList;

public class Count_subsequences_sum {
    public static int subsequence(int id,ArrayList<Integer> ls,int[] arr,int s,int sum,int n) {
        if (s > sum) {
            return 0;
        }
        if (id == n) {
            if (s == sum) {
                return 1;
            }
            return 0;
        }
        
        ls.add(arr[id]);
        s=s+arr[id];
        int l= subsequence(id+1, ls, arr, s, sum, n);

        ls.remove(ls.size()-1);
        s=s-arr[id];
        int r= subsequence(id+1, ls, arr, s, sum, n);
        
        return l+r;
    }
    public static void main(String[] args) {
        int[] arr={1,2,1};
        int n=arr.length;
        int sum=2;
        ArrayList<Integer> ls= new ArrayList<>();

        int ans=subsequence(0,ls,arr,0,sum,n);
        System.out.println(ans);
    }
}
