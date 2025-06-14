//optimal
//https://leetcode.com/problems/candy/submissions/1573493714/

public class Candy3 {

    public static int minCandies(int[] arr){
        int n=arr.length;
        int sum=1;
        int i=1;
        while (i<n) {
            if (arr[i]==arr[i-1]) {
                sum=sum+1;
                i++;
                continue;
            }
            int peak=1;
            while (i<n && arr[i]>arr[i-1]) {
                peak += 1;
                sum += peak;
                i++;
            }
            int down=1;
            while (i<n && arr[i]<arr[i-1]) {
                sum += down;
                down += 1;
                i++;
            }
            if (down>peak) {
                sum += down-peak;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
                // 0 1 2 3 4 5 6 7 8 9 10 11 12
        int[] arr={0,2,4,3,2,1,1,3,5,6,4, 0, 0};

        int ans=minCandies(arr);
        System.out.println(ans);
    }
}
