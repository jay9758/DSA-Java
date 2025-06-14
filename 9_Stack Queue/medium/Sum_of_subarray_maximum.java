//https://leetcode.com/problems/sum-of-subarray-minimums/

import java.util.Stack;

public class Sum_of_subarray_maximum {

    public static int[] findNge(int[] arr) {
        int n=arr.length;
        int[] nge=new int[n];
        Stack<Integer> st=new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()]<=arr[i]) {
                st.pop();
            }
            nge[i]=st.isEmpty() ? n : st.peek();
            st.push(i); 
        }
        return nge;
     } 

     public static int[] findPge(int[] arr) {
        int n=arr.length;
        int[] pge=new int[n];
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()]<arr[i]) {
                st.pop();
            }
            pge[i]=st.isEmpty() ? -1 : st.peek();
            st.push(i); 
        }
        return pge;
     } 

    public static int sumOfSubarrayMax(int[] arr){
        int n=arr.length;
        int[] nge=findNge(arr);
        int[] pge=findPge(arr);
        long total=0;
        int mod=(int)(1e9+7);
        for (int i = 0; i < n; i++) {
            int left=i-pge[i];
            int right=nge[i]-i;
            total=(total+(right*left*1L*arr[i])%mod)%mod;
        }
        System.out.println(total);
        return (int)total;
    }

    public static void main(String[] args) {
        int[] arr={1,4,3,2};

        int ans=sumOfSubarrayMax(arr);
        System.out.println(ans);
    }
}
