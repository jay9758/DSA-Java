
import java.util.ArrayList;
import java.util.List;

public class N_Queen {

    public static boolean isValid(char[][] board,int row,int col){
        int duprow=row;
        int dupcol=col;
        while (row>=0 && col>=0) {
            if (board[row][col]=='Q') {
                return false;
            }
            row--;
            col--;
        }
        row=duprow;
        col=dupcol;
        while (col>=0) {
            if (board[row][col]=='Q') {
                return false;
            }
            col--;
        }
        row=duprow;
        col=dupcol;
        while (row<board.length && col>=0) {
            if (board[row][col]=='Q') {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    public static List<String> construct(char[][] board){
        List<String> res=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s=new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void placeQueens(int col,char board[][],List<List<String>> ans){
        int n=board.length;
        if (col==n) {
            ans.add(construct(board)); //function char[][] to List<String>
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isValid(board,row,col)) {
                board[row][col]='Q';
                placeQueens(col+1, board, ans);
                board[row][col]='.';
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
        placeQueens(0,board,ans);
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
