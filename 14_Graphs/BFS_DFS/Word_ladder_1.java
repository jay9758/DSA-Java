//https://leetcode.com/problems/word-ladder/submissions/1660666761/
//https://www.geeksforgeeks.org/problems/word-ladder/1

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Pair {

    String first;
    int second;

    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Word_ladder_1 {

    public static int wordLadderLength(String beginWord, String endWord, String[] wordList) {
        int n = wordList.length;
        Queue<Pair> q = new LinkedList<>();
        Set<String> st = new HashSet<>();

        q.offer(new Pair(beginWord, 1));
        for (int i = 0; i < n; i++) {
            st.add(wordList[i]);
        }
        st.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.poll();

            if (word.equals(endWord)) {
                return steps;
            }
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord) == true) {
                        st.remove(replacedWord);
                        q.offer(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        int ans = wordLadderLength(beginWord, endWord, wordList);
        System.out.println(ans);
    }
}
