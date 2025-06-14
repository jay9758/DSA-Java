//https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

public class Generate_Paranthesis {

    public static void generate(int openP,int closeP,String s,int n,List<String> res){
        if(openP==closeP && openP+closeP==n*2){
            res.add(s);
            return;
        }
        if(openP<n){
            generate(openP+1,closeP,s+"(",n,res);
        }
        if(closeP<openP){
            generate(openP,closeP+1,s+")",n,res);
        }
    }
    public static void main(String[] args) {
        int n=3;
        List<String> res=new ArrayList<>();
        generate(0,0,"",n,res);

        System.out.println(res);
    }
}
