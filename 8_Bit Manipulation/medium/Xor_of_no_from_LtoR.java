//https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-xor-of-numbers-from-l-to-r

public class Xor_of_no_from_LtoR {

    public static int Xor(int N){
        if (N%4==1) return 1;
        else if (N%4==2) return N+1;
        else if (N%4==3) return 0;
        else if (N%4==0) return N;
        return 0;
    }
    public static int XorLToR(int L,int R){
        return Xor(L-1) ^ Xor(R); //(1^2^3) ^ (1^2^3^4^5^6^7)
    }                             //4^5^6^7
    public static void main(String[] args) {
        int L=4;
        int R=7;
        int ans=XorLToR(L,R);

        System.out.println(ans);
    }
}
