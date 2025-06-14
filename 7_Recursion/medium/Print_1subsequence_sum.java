
import java.util.ArrayList;

public class Print_1subsequence_sum {
    public static boolean subsequence(int id,ArrayList<Integer> ls,int[] arr,int s,int sum,int n) {
        if (id==n) {
            if (s==sum) {
                System.out.println(ls);
                return true;
            }
            return false;
        }
        
        ls.add(arr[id]);
        s=s+arr[id];
        if (subsequence(id+1, ls, arr, s, sum, n)) {
            return true;
        }

        ls.remove(ls.size()-1);
        s=s-arr[id];
        if (subsequence(id+1, ls, arr, s, sum, n)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr={1,2,1};
        int n=arr.length;
        int sum=2;
        ArrayList<Integer> ls= new ArrayList<>();

        subsequence(0,ls,arr,0,sum,n);
    }
}
