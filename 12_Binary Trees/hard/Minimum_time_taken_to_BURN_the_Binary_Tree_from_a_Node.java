//https://www.geeksforgeeks.org/problems/burning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=burning-tree

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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

public class Minimum_time_taken_to_BURN_the_Binary_Tree_from_a_Node {

    public static void markParents(Node root,Map<Node,Node> parent){
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node current=q.poll();
            if (current.left!=null) {
                parent.put(current.left, current);
                q.offer(current.left);
            }
            if (current.right!=null) {
                parent.put(current.right, current);
                q.offer(current.right);
            }
        }
    }

    public static int minTime(Node root,Node start){
        Map<Node,Node> parent=new HashMap<>();
        markParents(root, parent);

        Map<Node,Boolean> visited=new HashMap<>();
        Queue<Node> q=new LinkedList<Node>();

        q.offer(start);
        visited.put(start, true);
        int time=0;

        while (!q.isEmpty()) {
            int size=q.size();
            int run=0;
            for (int i = 0; i < size; i++) {
                Node currNode=q.poll();
                if (currNode.left!=null && visited.get(currNode.left)==null) {
                    q.offer(currNode.left);
                    visited.put(currNode.left, true);
                    run=1;
                }
                if (currNode.right!=null && visited.get(currNode.right)==null) {
                    q.offer(currNode.right);
                    visited.put(currNode.right, true);
                    run=1;
                }
                if (parent.get(currNode)!=null && visited.get(parent.get(currNode))==null) {
                    q.offer(parent.get(currNode));
                    visited.put(parent.get(currNode), true);
                    run=1;
                }
            }
            if (run==1) {
                time++;
            }
        }
        return time;
    }


    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        int ans=minTime(root,root.left);
        System.out.println(ans);
    }
}
