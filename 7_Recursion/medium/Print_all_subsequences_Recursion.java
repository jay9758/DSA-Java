import java.util.ArrayList;

public class Print_all_subsequences_Recursion {
    public static void subsequence(int id,ArrayList<Integer> ls,int[] arr,int n) {
        if (id==n) {
            System.out.println(ls);
            return;
        }
        ls.add(arr[id]);
        subsequence(id+1, ls, arr, n);
        ls.remove(ls.size()-1);

        subsequence(id+1, ls, arr, n);
    }
    public static void main(String[] args) {
        int[] arr={3,1,2};
        int n=arr.length;
        ArrayList<Integer> ls= new ArrayList<>();

        subsequence(0,ls,arr,n);
    }
}
