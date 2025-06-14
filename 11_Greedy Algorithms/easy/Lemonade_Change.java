//https://leetcode.com/problems/lemonade-change/

public class Lemonade_Change {

    public static boolean isPossible(int[] bills){
        int n=bills.length;
        int five=0;
        int ten=0;
        for (int i = 0; i < n; i++) {
            //System.out.println(five+" "+ten);
            if (bills[i]==5) {
                five += 1;
            }
            else if (bills[i]==10) {
                if (five!=0) {
                    ten = ten+1;
                    five= five-1;
                }
                else{
                    return false;
                }
            }
            else{
                if (five!=0 && ten!=0) {
                    ten= ten-1;
                    five= five-1;
                }
                else if (five>=3) {
                    five -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills={5,5,5,10,20};
        //int[] bills={5,5,10,10,20};

        boolean ans=isPossible(bills);
        System.out.println(ans);
    }
}
