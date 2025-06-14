//better

public class Trapping_Rainwater {

    public static int traprainwater(int[] arr){
        int n=arr.length;
        int total=0;

        int[] prefixMax=new int[n];
        prefixMax[0]=arr[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i]=Math.max(prefixMax[i-1], arr[i]);
        }

        int[] suffixMax=new int[n];
        suffixMax[n-1]=arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            suffixMax[i]=Math.max(suffixMax[i+1], arr[i]);
        }
        //System.out.println("prefixMax"+Arrays.toString(prefixMax));
        //System.out.println("suffixMax"+Arrays.toString(suffixMax));

        for (int i = 0; i < n; i++) {
            int leftMax=prefixMax[i];
            int rightMax=suffixMax[i];
            if (arr[i]<leftMax && arr[i]<rightMax) {
                 total += Math.min(leftMax, rightMax)-arr[i];
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        
        int ans=traprainwater(arr);
        System.out.println(ans);
    }
}
