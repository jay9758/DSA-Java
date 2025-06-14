//https://leetcode.com/problems/sum-of-subarray-minimums/

import java.util.Stack;

public class Sum_of_subarray_minimum {

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
        return nse;
     }

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
        return pse;
     }

    public static int sumOfSubarrayMin(int[] arr){
        int n=arr.length;
        int[] nse=findNse(arr);
        int[] pse=findPse(arr);
        long total=0;
        int mod=(int)(1e9+7);
        for (int i = 0; i < n; i++) {
            int left=i-pse[i];
            int right=nse[i]-i;
            total=(total+(right*left*1L*arr[i])%mod)%mod;
        }
        return (int)total;
    }
    public static void main(String[] args) {
        int[] arr={3,1,2,4};

        int ans=sumOfSubarrayMin(arr);
        System.out.println(ans);
    }
}
