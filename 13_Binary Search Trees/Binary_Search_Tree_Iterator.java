//https://leetcode.com/problems/binary-search-tree-iterator/

import java.util.Stack;

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
public class Binary_Search_Tree_Iterator{

    private static Stack<Node> st=new Stack<Node>();

    public static void BSTiterator(Node root){
        pushAll(root);
    }

    public static boolean hasNext(){
        return !st.isEmpty();
    }
    
    public static int next(){
        Node temp=st.pop();
        pushAll(temp.right);
        return temp.data;
    }

    private static void pushAll(Node node){
        while (node!=null) {
            st.push(node);
            node=node.left;
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

        BSTiterator(root);
        System.out.println(hasNext());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(hasNext());
    }
}
