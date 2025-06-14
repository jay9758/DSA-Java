import java.util.ArrayList;
import java.util.List;

public class M_Coloring_Problem {

    public static boolean isSafe(int node, List<Integer> [] g,int[] color,int n,int col){
        for (int it : g[node]) {
            if (color[it]==col) {
                return false;
            }
        }
        return true;
    }
    public static boolean solve(int node, List<Integer> [] g,int[] color,int n,int M){
        if (node==n) {
            return true;
        }
        for (int i = 1; i <= M; i++) {
            if (isSafe(node,g,color,n,i)) {
                color[node]=i;
                if (solve(node+1, g, color, n, M)==true) {
                    return true;
                }
                color[node]=0;
            }
        }
        return false;
    }

    public static boolean graphColoring(List<Integer> [] g,int[] color,int i,int M){
        int n=g.length;
        if (solve(i,g,color,n,M)==true) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int N=4;
        int M=3;
        @SuppressWarnings("unchecked")
        List<Integer> [] g=new ArrayList[N];
        for (int i = 0; i < N; i++) {
            g[i]=new ArrayList<>();
        }
        g[0].add(1);
        g[1].add(0);
        g[1].add(2);
        g[2].add(1);
        g[2].add(3);
        g[3].add(2);
        g[3].add(0);
        g[3].add(0);
        g[0].add(2);
        g[2].add(0);
        int[] color=new int[N];

        boolean ans=graphColoring(g,color,0,M);
        
        System.out.println(ans);
    }
}
