package interview.prep.linkedlist;

/**
 * @author somendraprakash created on 20/07/20
 */
public class MergeTwoSortedList
{
    private class Node
    {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    public Node mergeTwoSortedList(Node firstList, Node secondList) {
        Node dummyNode = new Node(-1);
        Node head = dummyNode;
        while (firstList != null && secondList != null) {
            if (firstList.data < secondList.data) {
                dummyNode.link = firstList;
                firstList = firstList.link;
            } else {
                dummyNode.link = secondList;
                secondList = secondList.link;
            }
            dummyNode = dummyNode.link;
        }

        if (firstList != null) {
            dummyNode.link = firstList;
        }
        if (secondList != null) {
            dummyNode.link = secondList;
        }
        return head.link;
    }

    private Node mergeRecursive(Node firstList, Node secondList){
        if (firstList == null){
            return secondList;
        }
        if (secondList == null){
            return firstList;
        }
        if (firstList.data > secondList.data){
            secondList.link = mergeRecursive(firstList, secondList.link);
            return secondList;
        }else{
            firstList.link = mergeRecursive(firstList.link, secondList);
            return firstList;
        }
    }

    //merge k sorted list
    private Node mergeKSortedList(Node[] kHeads){
        for (int i = 0 ; i < kHeads.length -1 ; i= i+2){
            mergeRecursive(kHeads[i], kHeads[i+1]);
        }
        return null;
    }

    public Node addLast(int data, Node head) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = node;
        }
        return head;
    }

    public static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "\t");
            current = current.link;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = null;
        MergeTwoSortedList list1 = new MergeTwoSortedList();
        head1 = list1.addLast(1, head1);
        head1 = list1.addLast(2, head1);
        head1 = list1.addLast(3, head1);
        head1 = list1.addLast(5, head1);
        display(head1);

        Node head2 = null;
        MergeTwoSortedList list2 = new MergeTwoSortedList();
        head2 = list2.addLast(3, head2);
        head2 = list2.addLast(4, head2);
        head2 = list2.addLast(5, head2);
        head2 = list2.addLast(9, head2);
        display(head2);

        MergeTwoSortedList resultList = new MergeTwoSortedList();

        Node result = resultList.mergeRecursive(head1, head2);
        display(result);

    }
}
