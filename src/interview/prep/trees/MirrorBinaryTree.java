package interview.prep.trees;

/**
 * @author somendraprakash created on 08/08/20
 */
public class MirrorBinaryTree
{
    private static  class  Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private void mirrorBinaryTree(Node root){
        if (root == null){
            return;
        }
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
        //swap root.left and root.right
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    private void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + "\t");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        MirrorBinaryTree bt = new MirrorBinaryTree();
        Node root = new Node(40);
        root.left= new Node(30);
        root.left.left= new Node(25);
        root.left.right= new Node(35);

        root.right = new Node(50);
        root.right.left = new Node(45);
        root.right.right = new Node(67);
        System.out.println("Actual tree: ");
        bt.inOrder(root);
        System.out.println();
        System.out.println("Mirror tree: ");
        bt.mirrorBinaryTree(root);
        bt.inOrder(root);
    }
}
