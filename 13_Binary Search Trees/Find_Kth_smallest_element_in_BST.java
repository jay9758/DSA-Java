//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//https://www.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1

//https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1

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
public class Find_Kth_smallest_element_in_BST {

    public static void Inorder(Node root,int[] count,int k,int[] kthSmallest){
        if (root==null || count[0]>=k) {
            return;
        }
        Inorder(root.left, count, k, kthSmallest);
        count[0]++;
        if (count[0]==k) {
            kthSmallest[0]=root.data;
            return;
        }
        Inorder(root.right, count, k, kthSmallest);
    }

    public static void reverseInorder(Node root,int[] count,int k,int[] kthLargest){
        if (root==null || count[0]>=k) {
            return;
        }
        reverseInorder(root.right, count, k, kthLargest);
        count[0]++;
        if (count[0]==k) {
            kthLargest[0]=root.data;
            return;
        }
        reverseInorder(root.left, count, k, kthLargest);
    }

    public static int[] kthElements(Node root,int k){
        int[] kthSmallest=new int[]{Integer.MIN_VALUE};
        int[] kthLargest=new int[]{Integer.MIN_VALUE};
        int[] count=new int[]{0};

        Inorder(root, count, k, kthSmallest);
        count[0]=0;
        reverseInorder(root, count, k, kthLargest);

        return new int[]{kthSmallest[0],kthLargest[0]};
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
        root.right.left=new Node(10);
        root.right.right=new Node(14);
        
        int k=3;

        int[] kthElements=kthElements(root,k);
        System.out.println("kthSmallest "+kthElements[0]);
        System.out.println("kthLargest "+kthElements[1]);
    }
}
