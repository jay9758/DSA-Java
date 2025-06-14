public class Count_no_of_set_bits {
    public static void main(String[] args) {
        int n=12;

        int count=0;
        while (n>1) {
            count += n&1;
            n=n>>1;
        }
        if (n==1) {
            count +=1;
        }

        //2nd method-
        // int count=0;
        // while (n!=0) {
        //     n=n & (n-1);
        //     count++;
        // }
        System.out.println(count);

    }
}
