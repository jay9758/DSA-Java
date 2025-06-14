
import java.util.ArrayList;


public class Print_all_subsequences_Power_Set {

    public static void subsequence(String s,int n) {
        ArrayList<Integer> a= new ArrayList<>();
        for (int num = 0; num < Math.pow(2, n); num++) {
            String sub="";
            for (int i = 0; i < n; i++) {
                if ((num & (1<<i)) != 0) {
                    sub=sub+s.charAt(i);
                }
            }
            System.out.println(sub);
        }
    }
    public static void main(String[] args) {
        String s="abc";
        int n=s.length();

        subsequence(s,n);
    }
}
