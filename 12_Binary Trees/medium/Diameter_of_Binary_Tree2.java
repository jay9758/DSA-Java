//https://leetcode.com/problems/diameter-of-binary-tree/

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
public class Diameter_of_Binary_Tree2 {
    
    public static int heightOfTree(Node root,int[] diameter){
        if (root==null) {
            return 0;
        }
        int[] lh=new int[1];
        int[] rh=new int[1];
        lh[0]=heightOfTree(root.left,diameter);
        rh[0]=heightOfTree(root.right,diameter);
        diameter[0]=Math.max(diameter[0], lh[0]+rh[0]);
        return 1+Math.max(lh[0], rh[0]);
    }
    
    public static int diameterOfTree(Node root){
        int[] diameter=new int[1];
        diameter[0]=0;
        heightOfTree(root,diameter);
        return diameter[0];
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        int ans=diameterOfTree(root);
        System.out.println(ans);
    }
}
