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
public class Diameter_of_Binary_Tree {

    static int diameter=0;
    
    public static int heightOfTree(Node root){
        if (root==null) {
            return 0;
        }
        int lh=heightOfTree(root.left);
        int rh=heightOfTree(root.right);
        diameter=Math.max(diameter, lh+rh);
        return 1+Math.max(lh, rh);
    }
    
    public static int diameterOfTree(Node root){
        heightOfTree(root);
        return diameter;
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
