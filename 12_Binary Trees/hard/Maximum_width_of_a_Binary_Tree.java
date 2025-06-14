//https://leetcode.com/problems/maximum-width-of-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
class Pair{
    Node node;
    int idx;
    Pair(Node node,int idx){
        this.node=node;
        this.idx=idx;
    }
}
public class Maximum_width_of_a_Binary_Tree {

    public static int maxWidth(Node root){
        if (root==null) {
            return 0;
        }
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size=q.size();
            int min=q.peek().idx;
            int first=0;
            int last=0;
            for (int i = 0; i < size; i++) {
                int currIdx=q.peek().idx-min;
                Node node=q.peek().node;
                q.poll();
                if (i==0) {
                    first=currIdx;
                }
                if(i==size-1){
                    last=currIdx;
                }
                if (node.left!=null) {
                    q.offer(new Pair(node.left, currIdx * 2+1));
                }
                if (node.right!=null) {
                    q.offer(new Pair(node.right, currIdx * 2+2));
                }
            }
            ans=Math.max(ans, last-first+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        int ans=maxWidth(root);
        System.out.println(ans);
    }
}
