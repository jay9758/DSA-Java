//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

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
class BSTiterator{
    private Stack<Node> st=new Stack<Node>();
    //reverse=false (next)
    //reverse=true (before)
    boolean reverse=true;

    public BSTiterator(Node root,boolean isReverse){
        reverse=isReverse;
        pushAll(root);
    }

    public boolean hasNext(){
        return !st.isEmpty();
    }
    
    public int next(){
        Node temp=st.pop();
        if (reverse==false) {
            pushAll(temp.right);
        }
        else{
            pushAll(temp.left);
        }
        return temp.data;
    }

    private void pushAll(Node node){
        while (node!=null) {
            st.push(node);
            if (reverse==false) {
                node=node.left;
            }
            else{
                node=node.right;
            }
        }
    }
}
public class Two_Sum_In_BST_Check_if_pair_exists_with_Sum_K{

    public static boolean checkPairExist(Node root,int k){
        if (root==null) {
            return false;
        }
        BSTiterator l=new BSTiterator(root,false);
        BSTiterator r=new BSTiterator(root,true);
        
        int i=l.next();
        int j=r.next();
        while (i<j) {
            if (i+j==k) {
                return true;
            }
            else if(i+j<k){
                i=l.next();
            }
            else{
                j=r.next();
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(4);
        root.left.right=new Node(7);
        root.right=new Node(12);
        root.right.left=new Node(10);
        root.right.right=new Node(14);

        int k=9;
        System.out.println(checkPairExist(root,k));
    }
}
