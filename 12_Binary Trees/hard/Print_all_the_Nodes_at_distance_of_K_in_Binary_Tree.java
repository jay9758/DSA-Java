//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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

public class Print_all_the_Nodes_at_distance_of_K_in_Binary_Tree {

    public static void markParents(Node root,Node target,Map<Node,Node> parent){
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

    public static List<Integer> distance(Node root,Node target,int k){
        Map<Node,Node> parent=new HashMap<>();
        markParents(root, target, parent);

        Map<Node,Boolean> visited=new HashMap<>();
        Queue<Node> q=new LinkedList<Node>();

        q.offer(target);
        visited.put(target, true);
        int level=0;

        while (!q.isEmpty()) {
            int size=q.size();
            if (level==k) {
                break;
            }
            level++;
            for (int i = 0; i < size; i++) {
                Node currNode=q.poll();
                if (currNode.left!=null && visited.get(currNode.left)==null) {
                    q.offer(currNode.left);
                    visited.put(currNode.left, true);
                }
                if (currNode.right!=null && visited.get(currNode.right)==null) {
                    q.offer(currNode.right);
                    visited.put(currNode.right, true);
                }
                if (parent.get(currNode)!=null && visited.get(parent.get(currNode))==null) {
                    q.offer(parent.get(currNode));
                    visited.put(parent.get(currNode), true);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while (!q.isEmpty()) {
            Node node=q.poll();
            ans.add(node.data);
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

        List<Integer> ans=distance(root,root.left,1);
        System.out.println(ans);
    }
}
