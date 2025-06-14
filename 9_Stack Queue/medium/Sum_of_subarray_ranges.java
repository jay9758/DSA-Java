//https://leetcode.com/problems/sum-of-subarray-ranges/submissions/1564750596/

import java.util.Stack;

public class Sum_of_subarray_ranges {

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
        //System.out.println(total);
        return (int)total;
    }


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
        //System.out.println(total);
        return (int)total;
    }

    public static int sumOfSubRange(int[] arr){
        return sumOfSubarrayMax(arr) - sumOfSubarrayMin(arr);
    }
    public static void main(String[] args) {
        int[] arr={1,4,3,2};

        int ans=sumOfSubRange(arr);
        System.out.println(ans);
    }
}
