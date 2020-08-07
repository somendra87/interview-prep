package interview.prep.trees;

/**
 * @author somendraprakash created on 08/08/20
 */
public class UnivalBinaryTree
{
    private static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private boolean isUnivalTree(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.data != root.data){
            return false;
        }
        if (root.right != null && root.right.data != root.data){
            return  false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    private int univalTreeCount(Node root){
        if (root == null){
            return 0;
        }
        int univalCount = univalTreeCount(root.left) + univalTreeCount(root.right);
        if (isUnivalTree(root)){
            univalCount = univalCount + 1;
        }
        return univalCount;
    }

    public static void main(String[] args) {
        UnivalBinaryTree bt = new UnivalBinaryTree();
        Node root = new Node(10);
        root.left = new Node(10);
        root.left.left = new Node(10);
        root.left.right = new Node(10);
        root.right = new Node(10);
        root.right.left = new Node(10);
        root.right.right = new Node(10);
        System.out.println(bt.isUnivalTree(root));
        System.out.println(bt.univalTreeCount(root));
    }
}
