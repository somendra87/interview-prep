package interview.prep.trees;

import java.util.*;

/**
 * @author somendraprakash created on 28/08/20
 */
public class BottomUpLevelOrderTraversal
{
    private static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private List<List<Integer>> bottomUpLevelOrderTraversal(Node root){
        List<List<Integer>> resultList = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int sizeAtTheLevel = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i =0 ; i< sizeAtTheLevel ; i++){
                Node popped = queue.poll();
                if (Objects.nonNull(popped)) {

                    if (Objects.nonNull(popped.left)) {
                        queue.offer(popped.left);
                    }
                    if (Objects.nonNull(popped.right)) {
                        queue.offer(popped.right);
                    }
                    list.add(popped.data);
                }
            }
            resultList.add(0, list);
        }
        return resultList;
    }

    private void display(List<List<Integer>>  resultList){
        System.out.println(resultList);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        BottomUpLevelOrderTraversal bt = new BottomUpLevelOrderTraversal();

        bt.display(bt.bottomUpLevelOrderTraversal(root));
    }
}
