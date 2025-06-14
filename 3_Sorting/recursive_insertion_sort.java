
import java.util.Arrays;

public class recursive_insertion_sort {

    public static void recins(int arr[],int i,int n){
            if(i==n){
                return;
            }
            while (i>0 && arr[i-1]>arr[i]) {
                int temp=arr[i-1];
                arr[i-1]=arr[i];
                arr[i]=temp;
                i--;
            }
            recins(arr, i+1, n);
         }
    public static void main(String[] args) {
        int[] arr={4,2,77,5,1,0};

        recins(arr,0,arr.length);

        System.out.println(Arrays.toString(arr));
    }
}
