package interview.prep.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author somendraprakash created on 24/09/20
 */
public class MaxSumPathInBT
{
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static TreeNode add(int val){
        return new TreeNode(val);
    }

    /**
     * This method finds all the paths in the tree which adds up to given sum
     * adds that path into an arraylist and returns the list of list integers which is
     * list of all the paths
     * @param root start of the tree
     * @param sum target sum
     * @return lists of the paths ( List<List<Integer></>></> paths)
     */
    private List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, sum , new ArrayList<Integer>(), paths);
        return paths;
    }

    private void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> paths){
        //Base case
        if(root == null){
            return;
        }
        // did we get what we were looking for if yes then return
        current.add(root.val);
        if(root.val == sum && (root.left == null && root.right == null)){
            paths.add(current);
            return;
        }

        // Recurse on the left subtree and right subtree if we did not get what we were         // looking for
        findPaths(root.left, sum - root.val, new ArrayList<Integer>(current), paths);
        findPaths(root.right, sum - root.val, new ArrayList<Integer>(current), paths);
    }

    private void printTree(TreeNode root){
        if (root == null){
            return;
        }
        printTree(root.left);
        System.out.print(root.val + "\t");
        printTree(root.right);
    }

    /**
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  /  \    / \
     * 7    2  5   1
     *
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     * @param args args
     */
    public static void main(String[] args) {
        MaxSumPathInBT bt = new MaxSumPathInBT();
        TreeNode root = add(5);
        root.left = add(4);
        root.left.left = add(11);
        root.left.left.left = add(7);
        root.left.left.right = add(2);

        root.right = add(8);
        root.right.left = add(13);
        root.right.right = add(4);
        root.right.right.left = add(5);
        root.right.right.right = add(1);
        System.out.println("tree is : ");
        bt.printTree(root);
        System.out.println();
        List<List<Integer>> lists = bt.pathSum(root, 22);
        System.out.println(lists);
    }


}
