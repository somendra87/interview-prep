package interview.prep.trees;

/**
 * Building a binary tree using inorder and preorder traversals
 *
 * @author somendraprakash created on 24/09/20
 */
public class BuildTree
{
    private static class Node
    {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.left = null;
        }
    }

    private Node buildTree(int[] inOrderArr, int[] preOrderArr, int size) {
        return buildTreeHelper(inOrderArr, preOrderArr, 0, size - 1, 0, size - 1);
    }

    private Node buildTreeHelper(int[] inOrderArr, int[] preOrderArr, int inStart, int inEnd, int preStart,
                                 int preEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootData = preOrderArr[preStart];
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrderArr[i] == rootData) {
                rootIndex = i;
                break;
            }
        }
        int leftPreStart = preStart + 1;
        int leftInStart = inStart;
        int leftInEnd = rootIndex - 1;
        /**
         * left ka pre order end - left ka pre order start will be same as left ka inorder end - left ka inorder start
         * leftPreEnd - leftPreStart = leftInEnd - leftInStart
         * there for leftpreEnd = leftInEnd - leftInStart + leftPreStart
         */
        int leftPreEnd = leftInEnd - leftInStart + leftPreStart;
        ;
        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = preEnd;
        int rightInStart = rootIndex + 1;
        int rightInEnd = inEnd;
        Node root = new Node(rootData);
        root.left = buildTreeHelper(inOrderArr, preOrderArr, leftInStart, leftInEnd, leftPreStart, leftPreEnd);
        root.right = buildTreeHelper(inOrderArr, preOrderArr, rightInStart, rightInEnd, rightPreStart, rightPreEnd);
        return root;
    }

    private void printRoot(Node root){
        if (root == null){
            return;
        }
        printRoot(root.left);
        printRoot(root.right);
        System.out.print(root.val + "\t");
    }
    public static void main(String[] args) {
        int[] inOrderArr = {4, 2, 5, 1, 8, 6, 9, 3, 7};
        int[] preOrder = {1, 2, 4, 5, 3, 6, 8, 9, 7};
        int size = inOrderArr.length;
        BuildTree buildTree = new BuildTree();
        Node root = buildTree.buildTree(inOrderArr, preOrder, size);
        buildTree.printRoot(root);
    }
}
