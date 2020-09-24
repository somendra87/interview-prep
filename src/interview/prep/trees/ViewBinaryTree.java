package interview.prep.trees;

import java.util.*;

/**
 * @author somendraprakash created on 24/08/20
 */
public class ViewBinaryTree
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

    private void rightSideView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node removedNode = queue.poll();
                if (Objects.nonNull(removedNode) && i == 0) {
                    resultList.add(removedNode.data);
                }
                if (Objects.nonNull(removedNode) &&
                        Objects.nonNull(removedNode.right)) {
                    queue.offer(removedNode.right);
                }
                if (Objects.nonNull(removedNode) &&
                        Objects.nonNull(removedNode.left)) {
                    queue.offer(removedNode.left);
                }
            }
        }
        resultList.forEach(x -> System.out.print(x + "\t"));
    }

    private void leftSideView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node removedNode = queue.poll();
                if (Objects.nonNull(removedNode) && i == 0) {
                    resultList.add(removedNode.data);
                }
                if (Objects.nonNull(removedNode) &&
                        Objects.nonNull(removedNode.left)) {
                    queue.offer(removedNode.left);
                }
                if (Objects.nonNull(removedNode) &&
                        Objects.nonNull(removedNode.right)) {
                    queue.offer(removedNode.right);
                }
            }
        }
        resultList.forEach(x -> System.out.print(x + "\t"));
    }

    private void verticalOrderTraversal(
            Node root,
            int horizontalDistance,
            Map<Integer, List<Node>> map
    ) {
        if (root == null) {
            return;
        }
        List<Node> list = map.get(horizontalDistance);
        if (list == null) {
            list = new LinkedList<>();
            list.add(root);
        } else {
            list.add(root);
        }
        map.put(horizontalDistance, list);
        verticalOrderTraversal(root.left, horizontalDistance - 1, map);
        verticalOrderTraversal(root.right, horizontalDistance + 1, map);
    }

    private void printVertical(Node root) {
        final String S1 = "{";
        final String S2 = " = [";
        final String S3 = "]";
        final String S4 = "}";
        final String S5 = " ";
        //create a map to store vertical orders
        Map<Integer, List<Node>> map = new HashMap<>();
        int horizontalDistance = 0;
        verticalOrderTraversal(root, horizontalDistance, map);

        // traverse the map and print the list at each horizontal distance
        map = new TreeMap<>(map);
        map.forEach((key, value) -> {
            StringBuffer buffer = new StringBuffer();
            buffer.append(S1).append(key).append(S2);
            value.forEach(x -> buffer.append(x.data).append(S5));
            buffer.append(S3).append(S4);
            System.out.println(buffer);
        });
        for (Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
            entry.getValue().forEach(x -> System.out.print(x.data + "\t"));
        }

        //PRINTING TOP VIEW OF THE BINARY TREE
        System.out.println("Printing TOP view of the Binary tree: ");
        map.forEach((key, value) -> System.out.print(value.get(0).data + "\t"));
    }

    private void topViewOfBinaryTree(Node root) {

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.right = new Node(4);
        ViewBinaryTree viewBinaryTree = new ViewBinaryTree();
        System.out.println("Right side view of the binary tree is : ");
        viewBinaryTree.rightSideView(root);
        System.out.println();
        System.out.println("Left side view of the binary tree is : ");
        viewBinaryTree.leftSideView(root);
        System.out.println();

        System.out.println("vertical order traversal : ");
        viewBinaryTree.printVertical(root);
    }
}
