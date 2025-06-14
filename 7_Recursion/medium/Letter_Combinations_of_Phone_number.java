//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_Phone_number {

    public static void combinations(String digits,int idx,StringBuilder comb,Map<Character,String> digitToLetter,List<String> res){
        if (digits=="" || digits.length()==0) {
            return;
        }
        if (idx==digits.length()) {
            res.add(new String(comb));
            return;
        }

        String letters=digitToLetter.get(digits.charAt(idx));
        for (char letter : letters.toCharArray()) {
            comb.append(letter);
            combinations(digits, idx+1, comb, digitToLetter, res);
            comb.deleteCharAt(comb.length()-1);
        }
    }

    public static void main(String[] args) {
        String digits="23";
        List<String> res=new ArrayList<>();

        Map<Character,String> digitToLetter=new HashMap<>();
        digitToLetter.put('2', "abc");
        digitToLetter.put('3', "def");
        digitToLetter.put('4', "ghi");
        digitToLetter.put('5', "jkl");
        digitToLetter.put('6', "mno");
        digitToLetter.put('7', "pqrs");
        digitToLetter.put('8', "tuv");
        digitToLetter.put('9', "wxyz");

        combinations(digits,0,new StringBuilder(),digitToLetter,res);

        System.out.println(res);
    }
}
