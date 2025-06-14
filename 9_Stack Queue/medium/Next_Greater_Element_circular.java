//https://leetcode.com/problems/next-greater-element-ii/

import java.util.Arrays;
import java.util.Stack;

class Next_Greater_Element_circular {

    public static int[] nextGreater(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        for (int i = 2*n-1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek()<=arr[i%n]) {
                st.pop();
            }
            if (i<n) {
                ans[i]= st.isEmpty() ? -1 : st.peek();
            }
            st.push(arr[i%n]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={2,10,12,1,11};
        int[] ans=nextGreater(arr);
        System.out.println(Arrays.toString(ans));
    }
}