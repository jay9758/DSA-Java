//https://leetcode.com/problems/sliding-window-maximum/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Sliding_Window_maximum {

    public static List<Integer> slidWindowMax(int[] arr,int k){
        int n=arr.length;
        List<Integer> ls=new ArrayList<>();
        Deque<Integer> dq=new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.getFirst()<=i-k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && arr[dq.getLast()]<=arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (i>=k-1) {
                ls.add(arr[dq.getFirst()]);
            }
        }
        return ls;
    }
    public static void main(String[] args) {
        int[] arr={1,3,-1,-3,5,3,7,1,6};
        int k=3;

        List<Integer> ls=slidWindowMax(arr,k);
        System.out.println(ls);
    }
}
