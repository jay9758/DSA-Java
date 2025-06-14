//https://www.geeksforgeeks.org/problems/the-celebrity-problem/1

public class The_Celebrity_Problem {

    public static int celebrityPerson(int[][] mat){
        int n=mat.length;
        int top=0;
        int down=n-1;
        while (top<down) {
            if (mat[top][down]==1) {
                top++;
            }
            else if (mat[down][top]==1) {
                down--;
            }
            else{
                top++;
                down--;
            }
        }
        if (top>down) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            if (i==top) {
                continue;
            }
            if (mat[top][i]==0 && mat[i][top]==1) {
                continue;
            }
            else{
                return -1;
            }
        }
        return top;
    }
    public static void main(String[] args) {
        int[][] mat={{0,1,1,0},
                     {0,0,0,0},
                     {0,1,0,0},
                     {1,1,0,0}};
        
        int ans=celebrityPerson(mat);
        System.out.println(ans);             
    }
}
