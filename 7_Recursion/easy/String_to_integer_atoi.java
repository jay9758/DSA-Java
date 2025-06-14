//https://leetcode.com/problems/string-to-integer-atoi/

public class String_to_integer_atoi {

    public static int stringToInt(String s){
        int res=0;
        int i=0;
        int sign=1;
        while (i<s.length() && s.charAt(i)==' ') {
            i++;
        }
        if (i<s.length() && s.charAt(i)=='-') {
            sign=-1;
            i++;
        }
        else if (i<s.length() && s.charAt(i)=='+') {
            sign=1;
            i++;
        }
        while (i<s.length() && s.charAt(i) >='0' && s.charAt(i) <='9') {
            int digit=s.charAt(i)-'0';
            if (res > (Integer.MAX_VALUE - digit)/10) {
                return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res=(res*10)+digit;
            i++;
        }
        return res*sign;
    }
    public static void main(String[] args) {
        String  s =  "42";

        int n=stringToInt("+1");
        System.out.println(n);
    }
}
