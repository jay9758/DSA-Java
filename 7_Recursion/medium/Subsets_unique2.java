//optimal

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Subsets_unique2 {
    public static void subsets(int id,int[] arr,List<Integer> sub,List<List<Integer>> ls){
        int n=arr.length;
        
        ls.add(new ArrayList<>(sub));
        for (int i = id; i < n; i++) {
            if (i!=id && arr[i]==arr[i-1]) {
                continue;
            }
            sub.add(arr[i]);
            subsets(i+1, arr, sub, ls);    
            sub.remove(sub.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] arr={1,2,2};
        int n=arr.length;
        Arrays.sort(arr);
        List<Integer> sub=new ArrayList<>();
        List<List<Integer>> ls=new ArrayList<>();

        subsets(0,arr,sub,ls);
        System.out.println(ls);
    }
}

