
import java.util.Arrays;

public class recursive_bubble_sort {

    public static void rec(int arr[],int n){
        if(n==1){
            return;
        }
        for (int j = 0; j < n-1; j++) {
            if(arr[j]>arr[j+1]){
            int temp=arr[j+1];
            arr[j+1]=arr[j];
            arr[j]=temp;
        }
        }
        rec(arr, n-1);
    }
    public static void main(String[] args) {
        int[] arr={4,3,14,1};

        rec(arr, arr.length);

        // for (int i = 0; i < arr.length-1; i++) {
        //     for (int j = 0; j < arr.length-i-1; j++){
        //         if(arr[j]>=arr[j+1]){
                    // int temp=arr[j+1];
                    // arr[j+1]=arr[j];
                    // arr[j]=temp;
        //         }
        //     }
        // }

        System.out.println(Arrays.toString(arr));
        }
    }

