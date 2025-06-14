//https://leetcode.com/problems/count-complete-tree-nodes/

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
public class Count_total_Nodes_in_a_COMPLETE_Binary_Tree {

    public static int leftHeight(Node node){
        int height=0;
        while (node.left!=null) {
            height++;
            node=node.left;
        }
        return height;
    }

    public static int rightHeight(Node node){
        int height=0;
        while (node.right!=null) {
            height++;
            node=node.right;
        }
        return height;
    }
    
    public static int totalNodes(Node root){
        if (root==null) {
            return 0;
        }
        int lh=leftHeight(root);
        int rh=rightHeight(root); 
        if ((lh==rh)) {
            return (2<<lh)-1;
            //return (1<<(lh+1))-1;
        }
        else{
            return 1+totalNodes(root.left)+totalNodes(root.right);
        }
    }


    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        // root.right.left=new Node(6);
        // root.right.right=new Node(7);

        int ans=totalNodes(root);
        System.out.println(ans);
    }
}
