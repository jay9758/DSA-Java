//https://www.interviewbit.com/problems/nearest-smaller-element/

import java.util.Arrays;
import java.util.Stack;

public class Next_Smaller_Element {

    public static int[] nextSmallerElement(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] nse=new int[n];
        int i=0;
        while (i<n) {
            while (!st.isEmpty() && st.peek()>arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nse[i]=-1;
                st.push(arr[i]);
            }
            else{
                nse[i]=st.peek();
                st.push(arr[i]);
            }
            i++;
        }
        return nse;
    }
    public static void main(String[] args) {
        int[] arr={4, 5, 2, 10, 8};

        int[] nse=nextSmallerElement(arr);
        System.out.println(Arrays.toString(nse));
    }
}
