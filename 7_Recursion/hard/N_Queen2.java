//https://leetcode.com/problems/n-queens/submissions/1551620107/

import java.util.ArrayList;
import java.util.List;

public class N_Queen2 {

    public static List<String> construct(char[][] board){
        List<String> res=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s=new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void placeQueens(int col,char board[][],List<List<String>> ans,int leftRow[],int upperDiagonal[],int lowerDiagonal[]){
        int n=board.length;
        if (col==n) {
            ans.add(construct(board)); //funtion char[][] to List<String>
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[n-1+col-row]==0) {  
                board[row][col]='Q';
                leftRow[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[n-1+col-row]=1;

                placeQueens(col+1, board, ans,leftRow,upperDiagonal,lowerDiagonal);
                board[row][col]='.';
                leftRow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[n-1+col-row]=0;
            }
        }
    }

    public static List<List<String>> solveNQueens(int n){
        char[][] board=new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }
        List<List<String>> ans=new ArrayList<>();
        int leftRow[]=new int[n];
        int upperDiagonal[]=new int[2*n-1];
        int lowerDiagonal[]=new int[2*n-1];
        placeQueens(0,board,ans,leftRow,upperDiagonal,lowerDiagonal);
        return ans;
    }
    
    
    public static void main(String[] args) {
         int n=4;

        List<List<String>> res= solveNQueens(n);

        for (List<String> board : res) {
             for (String row : board) {
                 System.out.println("["+ row +"]");
             }
             System.out.println();
        }
    }
}
