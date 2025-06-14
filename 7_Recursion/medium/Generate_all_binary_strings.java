//https://www.geeksforgeeks.org/generate-binary-strings-without-consecutive-1s/?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=generate-binary-strings-without-consecutive-1s

public class Generate_all_binary_strings {

    public static void generateStrings(int k,char[] str,int n){
        if (n==k) {
            System.out.println(str);
            return;
        }

        if (str[n-1]=='1') {
            str[n]='0';
            generateStrings(k, str, n+1);
        }

        if (str[n-1]=='0') {
            str[n]='0';
            generateStrings(k, str, n+1);
            str[n]='1';
            generateStrings(k, str, n+1);
        }
    }
    public static void main(String[] args) {
        int k=3;
        char[] str=new char[k];
        
        str[0]='0';
        generateStrings(k,str,1);
        str[0]='1';
        generateStrings(k,str,1);
    }
}
