//brute

import java.util.Stack;

public class Largest_rectangle_in_histogram {

    public static int[] findPse(int[] arr) {
        int n=arr.length;
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()]>arr[i]) {
                st.pop();
            }
            pse[i]=st.isEmpty() ? -1 : st.peek();
            st.push(i); 
        }
        //System.out.println("pse "+Arrays.toString(pse));
        return pse;
    }

    public static int[] findNse(int[] arr) {
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()]>=arr[i]) {
                st.pop();
            }
            nse[i]=st.isEmpty() ? n : st.peek();
            st.push(i); 
        }
        //System.out.println("nse "+Arrays.toString(nse));
        return nse;
    } 

    public static int largestRectangle(int[] arr){
        int n=arr.length;
        int max=0;
        int[] pse=findPse(arr);
        int[] nse=findNse(arr);
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] * (nse[i]-pse[i]-1));
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={2,1,5,6,2,3};
    
        int ans=largestRectangle(arr);
        System.out.println(ans);
    }
}
