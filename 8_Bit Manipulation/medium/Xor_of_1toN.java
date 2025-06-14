
public class Xor_of_1toN {
    public static int Xor(int N){
        if (N%4==1) return 1;
        else if (N%4==2) return N+1;
        else if (N%4==3) return 0;
        else if (N%4==0) return 1;
        return 0;
    }
    public static void main(String[] args) {
        int N=6;
        
        int ans=Xor(N);
        System.out.println(ans);
    }
}
