//https://www.geeksforgeeks.org/problems/swap-two-numbers3844/1

class Swap_two_no_without_3rd_variable {
    public static void main(String[] args) {
        int a=12;
        int b=5;

        a=a^b; 
        b=a^b; //b=(a^b)^b=a
        a=a^b; //a=(a^b)^a=b
        System.out.println("a= "+a);
        System.out.println("b= "+b);
    }    
}