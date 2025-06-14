
import java.util.ArrayList;
import java.util.List;


public class minimum_number_of_coins {

    public static int minCoins(int[] coins,int v){
        int n=coins.length;
        List<Integer> list=new ArrayList<>();
        int count=0;
        for (int i = n-1; i >= 0; i--) {
            while (v>=coins[i]) {
                v = v-coins[i];
                list.add(coins[i]);
                count++;
            }
        }
        //System.out.println(list);
        return v==0 ? count : -1;
    }
    public static void main(String[] args) {
        int[] coins={1,2,5,10,20,50,100,500,1000};
        int v=49;

        int ans=minCoins(coins,v);
        System.out.println(ans);
    }
}
