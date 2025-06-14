//https://leetcode.com/problems/next-greater-element-i/submissions/1562381681/

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element_question {

    public static int[] nextGreaterElement(int[] nums1,int[] nums2){
        int n2 = nums2.length;
        Stack<Integer> st = new Stack<>();
        int[] ans2 = new int[n2];
        for (int i = n2 - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans2[i] = -1;
            } else {
                ans2[i] = st.peek();
            }
            st.push(nums2[i]);
        }

        int n1 = nums1.length;
        int[] ans1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j]) {
                    ans1[i] = ans2[j];
                }
            }
        }
        return ans1;
    }
    public static void main(String[] args) {
        int[] nums1={4,1,2};
        int[] nums2={1,3,4,2};

        int[] nge=nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(nge));
    }
}
