
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
public class Flatten_Binary_Tree_to_LinkedList_method2 {

    public static void flattenTreeToLinkedList(Node root){
        Stack<Node> st=new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node curr=st.pop();
            if (curr.right!=null) {
                st.push(curr.right);
            }
            if (curr.left!=null) {
                st.push(curr.left);
            }
            if (!st.isEmpty()) {
                curr.right=st.peek();
            }
            curr.left=null;
        }
    }


    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        flattenTreeToLinkedList(root);
        while (root!=null) {
            System.out.print(root.data+" ");
            root=root.right;
        }
    }
}
