//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

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
public class Construct_BST_from_preorder_traversal{

    public static Node constructTree(int[] preorder,int bound,int[] i){
        if (i[0]==preorder.length || preorder[i[0]]>bound) {
            return null;
        }
        Node root=new Node(preorder[i[0]++]);
        root.left=constructTree(preorder, root.data, i);
        root.right=constructTree(preorder, bound, i);
        return root;
    }

    public static Node constructBST(int[] preorder){
        return constructTree(preorder,Integer.MAX_VALUE,new int[]{0});
    }

    public static void printTree(Node root){
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size=q.size();
            for (int i = 0; i < size; i++) {
                Node node=q.poll();
                System.out.print(node.data+" ");
                if (node.left!=null) q.add(node.left);
                if (node.right!=null) q.add(node.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] preorder={8,5,1,7,10,12};

        Node root= constructBST(preorder);
        printTree(root);
    }
}
