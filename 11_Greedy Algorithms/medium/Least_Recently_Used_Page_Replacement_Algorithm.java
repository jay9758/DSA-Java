//https://www.geeksforgeeks.org/problems/page-faults-in-lru5603/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=page-faults-in-lru

import java.util.LinkedList;
import java.util.Queue;

public class Least_Recently_Used_Page_Replacement_Algorithm {

    public static int pageFaults(int[] pages,int capacity){
        int n=pages.length;
        Queue<Integer> q=new LinkedList<Integer>();
        int count=0;
        for (int i = 0; i < n; i++) {
            if (!q.contains(pages[i])) {
                count++;
                q.add(pages[i]);
                if (q.size()>capacity) {
                    q.remove();
                }
            }
            else{
                q.remove();
                q.add(pages[i]);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] pages={5, 0, 1, 3, 2, 4, 1, 0, 5};
        int capacity=4;

        int ans=pageFaults(pages,capacity);
        System.out.println(ans);
    }
}
