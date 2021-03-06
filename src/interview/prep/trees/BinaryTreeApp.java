package interview.prep.trees;

import java.util.LinkedList;

/**
 * @author somendraprakash created on 01/08/20
 */
public class BinaryTreeApp
{
    private static class Node
    {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    private Node addNodeToTree(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.leftChild = addNodeToTree(root.leftChild, data);
        } else if (data > root.data) {
            root.rightChild = addNodeToTree(root.rightChild, data);
        } else {
            // if value is already present in the tree
            return root;
        }
        return root;
    }



    private int height(Node root) {
        if (root == null) {
            return -1;
        }

        int leftSubtreeHeight = height(root.leftChild);
        int rightSubtreeHeight = height(root.rightChild);
        return Math.min(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSize = size(root.leftChild);
        int rightSize = size(root.rightChild);

        return leftSize + 1 + rightSize;
    }

    private int maxInTheTree(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int maxVal = root.data;
        int leftMax = maxInTheTree(root.leftChild);
        int rightMax = maxInTheTree(root.rightChild);
        if (leftMax > maxVal) {
            maxVal = leftMax;
        }
        if (rightMax > maxVal) {
            maxVal = rightMax;
        }
        return maxVal;
    }

    private int sumOfAllNodes(Node root) {
        if (root == null) {
            return 0;
        }

        // find sum of all nodes in left subtree
        int leftSubtreeSum = sumOfAllNodes(root.leftChild);
        int rightSubtreeSum = sumOfAllNodes(root.rightChild);
        return leftSubtreeSum + rightSubtreeSum + root.data;
    }

    private void inOrderTraverSal(Node root) {
        if (root == null) {
            return;
        }
        // Left ROOT Right
        inOrderTraverSal(root.leftChild);
        System.out.print(root.data + "\t");
        inOrderTraverSal(root.rightChild);
    }

    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "\t");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    private void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.print(root.data + "\t");
    }

    private int numberOfLeafNodes(Node root) {
        // recursive equation
        //NL(root) = 1 : if root is leaf
        //           NL(LST) + NL(RST) : if root is internal node
        if (root == null) {
            return 0;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return 1;
        } else {
            return numberOfLeafNodes(root.leftChild) + numberOfLeafNodes(root.rightChild);
        }
    }

    private int internalNodesCount(Node root) {
        // internal nodes are non leaf nodes in the tree
        // internalCount(root) = 0 : if root is a leaf node
        //                     = 1 + internalCount(root.left) + internalCount(root.right)
        if (root == null) {
            return 0;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return 0;
        } else {
            return 1 + internalNodesCount(root.leftChild)
                    + internalNodesCount(root.rightChild);
        }
    }

    private int fullNodeCount(){
        // if the node is having all the children is called full children
        // in binary tree the full node will be a node having both child (left and right)
        //
        return 0;
    }

    private int findMin() {
        return 0;
    }

    private boolean isUnivalTree(Node root) {
        if (root == null) {
            return true;
        }
        if (root.leftChild != null && root.leftChild.data != root.data) {
            return false;
        }
        if (root.rightChild != null && root.rightChild.data != root.data) {
            return false;
        }
        return isUnivalTree(root.leftChild) && isUnivalTree(root.rightChild);
    }

    private int numberOfUnivalTrees(Node root) {
        if (root == null) {
            return 0;
        }
        int totalCount = numberOfUnivalTrees(root.leftChild)
                + numberOfUnivalTrees(root.rightChild);
        if (isUnivalTree(root)) {
            totalCount = totalCount + 1;
        }
        return totalCount;
    }

    private boolean isIdentical(Node tree1, Node tree2) {
        /*if (tree1 == null && tree2 != null) {
            return false;
        }
        if (tree1 != null && tree2 == null) {
            return false;
        }

        if (tree1 == null) {
            return true;
        }*/

        if (tree1 == null && tree2==null){
            return true;
        }
        if (tree1 != null && tree2 != null) {
            return tree1.data == tree2.data
                    && isIdentical(tree1.leftChild, tree2.leftChild)
                    && isIdentical(tree1.rightChild, tree2.rightChild);
        }
        return false;
    }

    private void levelOrderTraversal(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            Node removed = queue.removeFirst();
            System.out.print(removed.data + "\t");
            if (removed.leftChild != null) {
                queue.addLast(removed.leftChild);
            }
            if (removed.rightChild != null) {
                queue.addLast(removed.rightChild);
            }
        }
    }

    public void display(Node root) {
        //BASE CASE
        if (root == null) {
            return;
        }

        // self work --> the work we need to do (processing) apart from recursion
        String str = "";
        if (root.leftChild == null) {
            str = str + "NULL";
        } else {
            str = str + root.leftChild.data;
        }
        str = str + " -> " + root.data + " <-";
        if (root.rightChild == null) {
            str = str + "NULL";
        } else {
            str = str + root.rightChild.data;
        }
        System.out.println(str);

        //make recursive call on left subtree
        display(root.leftChild);

        //make recursive call on right subtree
        display(root.rightChild);
    }

    public static void main(String[] args) {
        BinaryTreeApp bt = new BinaryTreeApp();
        Node root = null;
        root = bt.addNodeToTree(root, 40);
        root = bt.addNodeToTree(root, 25);
        root = bt.addNodeToTree(root, 12);
        root = bt.addNodeToTree(root, 30);
        root = bt.addNodeToTree(root, 18);
        root = bt.addNodeToTree(root, 35);
        root = bt.addNodeToTree(root, 75);
        root = bt.addNodeToTree(root, 65);
        root = bt.addNodeToTree(root, 57);
        root = bt.addNodeToTree(root, 71);
        root = bt.addNodeToTree(root, 87);
        root = bt.addNodeToTree(root, 96);
        root = bt.addNodeToTree(root, 91);
        root = bt.addNodeToTree(root, 101);

        System.out.println("========TREE IS CONSTRUCTED AS FOLLOWS --------------");
        bt.display(root);
        System.out.println();

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Height of the tree rooted at " + root.data + " is : " + bt.height(root));
        //finding height of the tree rooted at 2
        //root = root.leftChild;
        //System.out.println("Height of the tree rooted at " + root.data + " is : " + bt.height(root));
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("size of the tree is : " + bt.size(root));
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Max val in the tree is : " + bt.maxInTheTree(root));
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Sum of all nodes of the binary tree is : " + bt.sumOfAllNodes(root));
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("----------- INORDER TRAVERSAL----------------");
        bt.inOrderTraverSal(root);
        System.out.println();

        System.out.println("----------- PREORDER TRAVERSAL----------------");
        bt.preOrderTraversal(root);
        System.out.println();

        System.out.println("----------- POSTORDER TRAVERSAL----------------");
        bt.postOrderTraversal(root);
        System.out.println();

        System.out.println("--------check if the tree is unival tree --------");
        System.out.println("Is tree unival tree : " + bt.isUnivalTree(root));
        System.out.println();

        BinaryTreeApp univalBt = new BinaryTreeApp();
        Node univalRoot = new Node(50);
        univalRoot.leftChild = new Node(45);
        univalRoot.leftChild.leftChild = new Node(30);
        univalRoot.leftChild.rightChild = new Node(49);

        univalRoot.rightChild = new Node(67);
        univalRoot.rightChild.leftChild = new Node(58);
        univalRoot.rightChild.rightChild = new Node(87);

        System.out.println("is the given tree unival tree : " + univalBt.isUnivalTree(univalRoot));
        System.out.println();
        System.out.println("Total number of unival trees are : " + univalBt.numberOfUnivalTrees(univalRoot));

        System.out.println();
        System.out.println("Are the given two trees identical : ");
        System.out.println(bt.isIdentical(root, univalRoot));

        System.out.println();
        System.out.println("Level order traversal of the tree : ");
        bt.levelOrderTraversal(univalRoot);
        System.out.println();

        System.out.println("Number of leaf nodes in the tree rooted at "
                + root.data + " is " + bt.numberOfLeafNodes(root));
        System.out.println();

        System.out.println("Number of internal node (non leaf) nodes " + bt.internalNodesCount(root));
        System.out.println();
    }

}
