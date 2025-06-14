//https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/1564860050/

import java.util.Stack;

public class Largest_rectangle_in_histogram2 {

    public static int largestRectangle(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int max=0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()]>arr[i]) {
                int v=arr[st.peek()];
                st.pop();
                int pse= st.isEmpty() ? -1 : st.peek();
                int nse=i;
                max = Math.max(max, v * (nse-pse-1));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int v=arr[st.peek()];
            st.pop();
            int pse= st.isEmpty() ? -1 : st.peek();
            int nse=n;
            max = Math.max(max, v * (nse-pse-1));
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={3,2,10,11,5,10,6,3};
        //int[] arr={2,4};

        int ans=largestRectangle(arr);
        System.out.println(ans);
    }
}
