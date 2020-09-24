package interview.prep.trees;

import java.util.*;

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

    private Node invertTree(Node root){
        if (root == null){
            return null;
        }
        int n = Math.abs(1);
        Node right = invertTree(root.right);
        Node left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    private void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + "\t");
        inOrder(root.right);
    }


    private int minHeight(Node root){
        if (root == null){
            return 0;
        }
        return Math.min(minHeight(root.left), minHeight(root.right))+1;
    }

    List<List<Integer>> levelOrderTraversal(Node root){
        if (root == null){
            return null;
        }else{
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()){
                Node removedNode = q.poll();
                List<Integer> list = new ArrayList<>();
                list.add(removedNode.data);
                if (removedNode.left != null){
                    q.offer(removedNode.left);
                }
                if (removedNode.right != null){
                    q.offer(removedNode.right);
                }
            }
        }
        return null;
    }

    List<Integer> rightViewOfTree(Node root){
        List<Integer> resultList = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0 ; i < size ; i ++){
                Node removedNode = q.poll();
                if (i == 0){
                    resultList.add(removedNode.data);
                }
                if (Objects.nonNull(removedNode) &&removedNode.left != null){
                    q.offer(removedNode.left);
                }
                if (Objects.nonNull(removedNode) && removedNode.right != null){
                    q.offer(removedNode.right);
                }
            }
        }
        return resultList;
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
        /*System.out.println("Mirror tree: ");
        bt.mirrorBinaryTree(root);
        bt.inOrder(root);*/
        bt.invertTree(root);
        bt.inOrder(root);
    }
}
