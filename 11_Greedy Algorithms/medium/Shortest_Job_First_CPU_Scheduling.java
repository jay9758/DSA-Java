//https://www.geeksforgeeks.org/problems/shortest-job-first/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-job-first

import java.util.Arrays;

public class Shortest_Job_First_CPU_Scheduling {

    public static int averageWaitTime(int[] arr){
        Arrays.sort(arr);
        int n=arr.length;
        int t=0;
        int WaitTime=0;
        for (int i = 0; i < n; i++) {
            WaitTime += t;
            t += arr[i];
        }
        return WaitTime/n;
    }
    public static void main(String[] args) {
        int[] arr={4,3,7,1,2};

        int ans=averageWaitTime(arr);
        System.out.println(ans);
    }
}
