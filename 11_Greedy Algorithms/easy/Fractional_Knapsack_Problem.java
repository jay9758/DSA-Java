//https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

import java.util.Arrays;
import java.util.Comparator;

class Item{
    int value,weight;

    Item(int value,int weight) {
        this.value=value;
        this.weight=weight;
    }
}

class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a,Item b){
        double r1=(double)(a.value) / (double)(a.weight);
        double r2=(double)(b.value) / (double)(b.weight);
        if (r1<r2) {
            return 1;
        }
        else if(r1>r2) {
            return -1;
        }
        else{
            return 0;
        }
    }
}

public class Fractional_Knapsack_Problem {

    public static double fractionalKnapsack(Item arr[],int w){
        int n=arr.length;
        Arrays.sort(arr,new itemComparator());
        int currWeight=0;
        double finalvalue=0;

        for (int i = 0; i < n; i++) {
            if (arr[i].weight<=w) {
                finalvalue += arr[i].value;
                w = w-arr[i].weight;
            }
            else{
                finalvalue += ((double)(arr[i].value) / (double)(arr[i].weight)) * w;
                break;
            }
        }
        return finalvalue;
    }
    public static void main(String[] args) {
        Item arr[]={new Item(100, 20),new Item(60, 10),new Item(100, 50),new Item(200, 50)};
        int w=90;
        
        double ans=fractionalKnapsack(arr,w);
        System.out.println(ans);
    }
}
