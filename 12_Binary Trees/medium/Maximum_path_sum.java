//https://leetcode.com/problems/binary-tree-maximum-path-sum/

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
public class Maximum_path_sum {
    
    public static int maxPath(Node root,int[] sum){
        if (root==null) {
            return 0;
        }
        int lh=Math.max(0,maxPath(root.left,sum));
        int rh=Math.max(0,maxPath(root.right,sum));
        sum[0]=Math.max(sum[0], lh+rh+root.data);
        return root.data+Math.max(lh, rh);
    }
    
    public static int maxPathSum(Node root){
        int[] sum=new int[1];
        sum[0]=0;
        maxPath(root,sum);
        return sum[0];
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        int ans=maxPathSum(root);
        System.out.println(ans);
    }
}
