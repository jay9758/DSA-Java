
import java.util.Arrays;
import java.util.Stack;

class Next_Greater_Element {

    public static int[] nextGreater(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek()<=arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={4,12,5,3,1,2,5,3,1,2,4,6};
        int[] ans=nextGreater(arr);
        System.out.println(Arrays.toString(ans));
    }
}