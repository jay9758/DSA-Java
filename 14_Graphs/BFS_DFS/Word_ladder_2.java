//https://www.geeksforgeeks.org/problems/word-ladder-ii/1
//give TLE on leetcode
//video link-https://youtu.be/DREutrv2XD0?si=dAvDgFdegGU-F8xB

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Word_ladder_2 {

    public static List<List<String>> findLadders(String beginWord, String endWord, String[] wordList) {
        Set<String> st = new HashSet<>();
        int n = wordList.length;
        for (int i = 0; i < n; i++) {
            st.add(wordList[i]);
        }
        Queue<List<String>> q = new LinkedList<>();

        List<String> ls=new ArrayList<>();
        ls.add(beginWord);
        q.offer(ls);

        List<String> usedOnLevel=new ArrayList<>();
        usedOnLevel.add(beginWord);

        int level=0;
        List<List<String>> ans=new ArrayList<>();

        while (!q.isEmpty()) {
            List<String> list = q.peek();
            String word=list.get(list.size()-1);
            q.poll();

            if (list.size()>level) {
                level++;
                for(String it : usedOnLevel){
                    st.remove(it);
                }
            }

            if (word.equals(endWord)) {
                if (ans.size()==0) {
                    ans.add(list);
                }
                else if (ans.get(0).size()==list.size()) {
                    ans.add(list);
                }
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord) == true) {
                        list.add(replacedWord);
                        List<String> newList = new ArrayList<>(list);
                        q.offer(newList);
                        usedOnLevel.add(replacedWord);
                        list.remove(list.size()-1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        List<List<String>> ans = findLadders(beginWord, endWord, wordList);
        System.out.println(ans);
    }
}
