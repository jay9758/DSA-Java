//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
public class Zig_Zag_Traversal_of_Binary_Tree {
    
    public static List<List<Integer>> zigzagTraversal(Node root){
        List<List<Integer>> ans=new ArrayList<>();
        if (root==null) {
            return ans;
        }
        Queue<Node> q=new LinkedList<Node>();
        q.offer(root);
        boolean leftToright=true;

        while (!q.isEmpty()) {
            int size=q.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node=q.poll();
                int idx= leftToright ? i : (size-1-i);

                if (leftToright) {
                    list.addLast(node.data);
                }
                else{
                    list.addFirst(node.data);
                }

                if (node.left!=null) {
                    q.offer(node.left);
                }
                if (node.right!=null) {
                    q.offer(node.right);
                }
            }
            leftToright= !leftToright;
            ans.add(list);
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

        List<List<Integer>> ans=zigzagTraversal(root);
        System.out.println(ans);
    }
}
