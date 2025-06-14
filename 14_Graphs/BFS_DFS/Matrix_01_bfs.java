//https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1

//almost similar question but for distance from 0
//https://leetcode.com/problems/01-matrix/submissions/1659573740/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row;
    int col;
    int dist;

    Pair(int row,int col,int dist) {
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}

public class Matrix_01_bfs {
    
    public static int[][] nearestDistance(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        int[][] ans=new int[n][m];
        int[][] vis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j]==1) {
                    q.offer(new Pair(i, j, 0));
                    vis[i][j]=1;
                }
            }
        }

        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        while (!q.isEmpty()) {
            int r=q.peek().row;
            int c=q.peek().col;
            int d=q.peek().dist;

            ans[r][c]=d;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if (nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && mat[nrow][ncol]==0) {
                    vis[nrow][ncol]=1;
                    q.offer(new Pair(nrow, ncol, d+1));
                }
            } 
        }
        //System.out.println(Arrays.deepToString(vis));
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat={{0,0,0},{0,1,0},{1,0,1}};

        //System.out.println(Arrays.deepToString(mat));
        int[][] ans=nearestDistance(mat);
        System.out.println(Arrays.deepToString(ans));
    }
}
