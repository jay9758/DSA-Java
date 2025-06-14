//https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

import java.util.Arrays;

class Job{
    int id,deadline,profit;

    Job(int id,int deadline,int profit) {
        this.id=id;
        this.deadline=deadline;
        this.profit=profit;
    }
}
public class Job_sequencing_Problem {

    public static int[] jobSchedule(Job arr[]){
        Arrays.sort(arr,(a,b) -> (b.profit - a.profit));
        int n=arr.length;
        int totalProfit=0;
        int count=0;
        int maxDeadline=0;
        for (int i = 0; i < n; i++) {
            maxDeadline=Math.max(maxDeadline, arr[i].deadline);
        }
        int[] hash=new int[maxDeadline+1];

        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (hash[j]==0) {
                    count++;
                    hash[j]=arr[i].id;
                    totalProfit += arr[i].profit;
                    break;
                }
            }
        }
        int[] ans=new int[2];
        ans[0]=count;
        ans[1]=totalProfit;
        return ans;
    }
    public static void main(String[] args) {
        Job[] arr=new Job[4];
        arr[0]=new Job(1,4,20);
        arr[1]=new Job(2,1,10);
        arr[2]=new Job(3,2,40);
        arr[3]=new Job(4,2,30);

        int[] ans=jobSchedule(arr);
        System.out.println("jobs: "+ans[0]+" profit: "+ans[1]);
    }
}
