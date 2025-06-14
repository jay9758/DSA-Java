//https://leetcode.com/problems/online-stock-span/submissions/1565681985/

import java.util.Stack;

class StockSpanner{
    Stack<int[]> st;
    int idx;

    public StockSpanner(){
        this.st=new Stack<>();
        this.idx=-1;
    }

    public int next(int price){
        idx=idx+1;
        while (!st.isEmpty() && st.peek()[0]<=price) {
            st.pop();
        }
        int ans=idx - (st.isEmpty() ? -1 : st.peek()[1]);
        st.push(new int[] {price,idx});
        return ans;
    }
}

public class Stock_span_problem {
    public static void main(String[] args) {
        StockSpanner stockSpanner=new StockSpanner();
        int[] arr={100,80,60,70,60,75,85};
        for (int price : arr) {
            System.out.print(stockSpanner.next(price)+" ");
        }
    }
}
