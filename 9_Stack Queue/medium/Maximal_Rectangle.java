//https://leetcode.com/problems/maximal-rectangle/

import java.util.Stack;

public class Maximal_Rectangle {

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

    public static int maxRectangle(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        int[][] arr=new int [n][m];
        for (int j = 0; j < m; j++) {
            int sum=0;
            for (int i = 0; i < n; i++) {
                sum +=mat[i][j];
                if (mat[i][j]==0) {
                    sum=0;
                }
                arr[i][j]=sum;
            }
        }

        int max=0;
        for (int i = 0; i < n; i++) {
            int currMax=largestRectangle(arr[i]);
            //System.out.println(currMax);
            max=Math.max(max, currMax);
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] mat={{1,0,1,0,1},
                     {1,0,1,1,1},
                     {1,1,1,1,1},
                     {1,0,0,1,0}};
         
        int ans=maxRectangle(mat);
        System.out.println(ans);   
    }
}
