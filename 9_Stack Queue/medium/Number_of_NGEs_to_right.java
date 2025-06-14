//https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-nges-to-the-right

import java.util.Arrays;

public class Number_of_NGEs_to_right {

    public static int[] noOfGreaterElementToRight(int[] arr,int[] indices){
        int n=arr.length;
        int[] ans=new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            int v=indices[i];
            int count=0;
            for (int j = v+1; j < n; j++) {
                if (arr[j]>arr[v]) {
                    count++;
                }
            }
            ans[i]=count;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={3, 4, 2, 7, 5, 8, 10, 6};
        int[] indices={0, 5};

        int[] nnge=noOfGreaterElementToRight(arr,indices);
        System.out.println(Arrays.toString(nnge));
    }
}
