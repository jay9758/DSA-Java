//optimize 
//https://leetcode.com/problems/word-ladder-ii/submissions/1660787708/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Word_ladder_2a {

    public static String b;
    public static HashMap<String, Integer> mpp;
    public static List<List<String>> ans;

    public static void dfs(String word, List<String> seq) {
        if (word.equals(b)) {
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps = mpp.get(word);
        int size = word.length();

        for (int i = 0; i < size; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                char replacedCharArray[] = word.toCharArray();
                replacedCharArray[i] = ch;
                String replacedWord = new String(replacedCharArray);
                if (mpp.containsKey(replacedWord) && mpp.get(replacedWord) + 1 ==steps) {
                    seq.add(replacedWord);
                    dfs(replacedWord, seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        int n = wordList.size();
        for (int i = 0; i < n; i++) {
            st.add(wordList.get(i));
        }
        Queue<String> q = new LinkedList<>();
        b = beginWord;
        q.offer(beginWord);
        mpp = new HashMap<>();
        mpp.put(beginWord, 1);
        int size = beginWord.length();
        st.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek();
            int steps = mpp.get(word);
            q.poll();

            if (word.equals(endWord)) {
                break;
            }

            for (int i = 0; i < size; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord) == true) {
                        q.add(replacedWord);
                        st.remove(replacedWord);
                        mpp.put(replacedWord, steps + 1);
                    }
                }
            }
        }
        ans = new ArrayList<>();
        if (mpp.containsKey(endWord) == true) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }
        return ans;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        List<List<String>> ans = findLadders(beginWord, endWord, wordList);
        System.out.println(ans);
    }
}
