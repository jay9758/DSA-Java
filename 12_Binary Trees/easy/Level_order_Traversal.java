//https://leetcode.com/problems/binary-tree-level-order-traversal/

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
public class Level_order_Traversal {

    public static List<List<Integer>> levelOrderTraversal(Node root){
        Queue<Node> q=new LinkedList<Node>();
        List<List<Integer>> ans=new LinkedList<List<Integer>>();
        if (root==null) {
            return ans;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int levelNo=q.size();
            List<Integer> list=new LinkedList<Integer>();
            for (int i = 0; i < levelNo; i++) {
                if (q.peek().left!=null) {
                    q.offer(q.peek().left);
                }
                if (q.peek().right!=null) {
                    q.offer(q.peek().right);
                }
                list.add(q.poll().data);
            }
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

        System.out.println(levelOrderTraversal(root));
    }
}
