//https://www.geeksforgeeks.org/problems/largest-bst/1

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
class NodeValue{
    int minNode;
    int maxNode;
    int maxSize;

    NodeValue(int minNode,int maxNode,int maxSize) {
        this.minNode=minNode;
        this.maxNode=maxNode;
        this.maxSize=maxSize;
    }
}

public class Largest_BST_in_Binary_Tree {

    public static NodeValue largestSubtree(Node root){
        if (root==null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left=largestSubtree(root.left);
        NodeValue right=largestSubtree(root.right);

        if (left.maxNode<root.data && root.data<right.minNode) {
            return new NodeValue(Math.min(root.data, left.minNode),
                                 Math.max(root.data, right.maxNode),
                                 left.maxSize+right.maxSize+1);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public static int largestBSTSubtree(Node root){
        return largestSubtree(root).maxSize;
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
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(4);
        root.left.right=new Node(7);
        root.right=new Node(12);
        root.right.left=new Node(14);
        root.right.right=new Node(10);

        int ans=largestBSTSubtree(root);
        System.out.println(ans);
    }
}
