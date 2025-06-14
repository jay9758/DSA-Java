//https://leetcode.com/problems/word-search/description/

import java.util.HashSet;
import java.util.Set;

public class Word_Search {

    public static boolean exist(char[][] board,String word, int r,int c,int k, Set<String> visited){
        int m=board.length;
        int n=board[0].length;

        if (k==word.length()) {
            return true;
        }

        if (r<0 || r>=m || c<0 || c>=n || visited.contains(r+","+c) || board[r][c]!=word.charAt(k)) {
            return false;
        }

        visited.add(r+","+c);
        boolean res=exist(board, word, r+1, c, k+1, visited) ||
                    exist(board, word, r-1, c, k+1, visited) ||
                    exist(board, word, r, c+1, k+1, visited) ||
                    exist(board, word, r, c-1, k+1, visited);
        visited.remove(r+","+c);
        
        return res;
    }

    public static boolean findWord(char[][] board,String word){
        int m=board.length;
        int n=board[0].length;
        Set<String> visited=new HashSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (exist(board, word, r, c, 0,visited)==true) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};
        String word="ABCCED";

        boolean ans = findWord(board,word);
        
        System.out.println(ans);
    }
}
