//https://www.geeksforgeeks.org/problems/two-numbers-with-odd-occurrences5846/1

import java.util.ArrayList;
import java.util.List;

public class Find_the_two_no_appear_single_time {

    public static void findNo(int[] arr,List<Integer> ans){
        long xor=0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        long rightMost= xor & (-xor);
        int b1=0;
        int b2=0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightMost) !=0) {
                b1=b1 ^ arr[i];
            }
            else{
                b2=b2 ^ arr[i];
            }
        }
        ans.add(b1);
        ans.add(b2);
    }
    public static void main(String[] args) {
        int[] arr={1,14,3,2,1,4,3,2};

        List<Integer> ans=new ArrayList<>();
        findNo(arr,ans);

        System.out.println(ans);
    }
}
