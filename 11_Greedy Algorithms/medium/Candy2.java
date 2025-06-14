//better

public class Candy2 {

    public static int minCandies(int[] arr){
        int n=arr.length;
        int[] left=new int[n];
        left[0]=1;
        for (int i = 1; i < n; i++) {
            if (arr[i]>arr[i-1]) {
                left[i]=left[i-1]+1;
            }
            else{
                left[i]=1;
            }
        }

        int curr=1;
        int right=1;
        int sum=Math.max(left[n-1],1);
        for (int i = n-2; i >= 0; i--) {
            if (arr[i]>arr[i+1]) {
                curr=curr+1;
            }
            else{
                curr=1;
            }
            //System.out.print(curr+" ");
            sum=sum+Math.max(left[i], curr);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr={0,2,4,3,2,1,1,3,5,6,4,0,0};

        int ans=minCandies(arr);
        System.out.println(ans);
    }
}
