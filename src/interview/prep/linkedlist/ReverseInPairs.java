package interview.prep.linkedlist;

/**
 * @author somendraprakash created on 19/07/20
 */
public class ReverseInPairs
{
    private static class Node
    {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    private Node add(int data, Node head) {
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

    private void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.link;
        }
        System.out.println();
    }

    private Node reverseInPairs(Node head) {
        int count = 0;
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null && count < 2) {
            next = current.link;
            current.link = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.link = reverseInPairs(current);
        }
        return prev;
    }

    private Node reverseInGroupdOfK(int k, Node head) {
        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while (current != null && count < k) {
            next = current.link;
            current.link = prev;
            prev = current;
            current = next;
            count++;
        }
        // if next is not null then and onlt then do the recursive call other wise exit
        if (next != null){
            head.link = reverseInGroupdOfK(k, current);
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseInPairs list = new ReverseInPairs();
        Node head = null;
        head = list.add(11, head);
        head = list.add(18, head);
        head = list.add(21, head);
        head = list.add(9, head);
        head = list.add(6, head);
        head = list.add(37, head);
        head = list.add(22, head);
        head = list.add(21, head);
        head = list.add(30, head);
        head = list.add(23, head);
        head = list.add(50, head);
        head = list.add(90, head);
        head = list.add(70, head);
        head = list.add(65, head);
        head = list.add(80, head);
        head = list.add(91, head);

        System.out.println("Original link list :");
        list.display(head);

        System.out.println("Pairwise reverse of link list ");
        Node reverseInPairsHead = list.reverseInPairs(head);
        list.display(reverseInPairsHead);


        ReverseInPairs list1 = new ReverseInPairs();
        Node head1 = null;
        head1 = list.add(11, head1);
        head1 = list.add(18, head1);
        head1 = list.add(21, head1);
        head1 = list.add(9, head1);
        head1 = list.add(6, head1);
        head1 = list.add(37, head1);
        head1 = list.add(22, head1);
        head1 = list.add(21, head1);
        head1 = list.add(30, head1);
        head1 = list.add(23, head1);
        head1 = list.add(50, head1);
        head1 = list.add(90, head1);
        head1 = list.add(70, head1);
        head1 = list.add(65, head1);
        head1 = list.add(80, head1);
        head1 = list.add(91, head1);
        System.out.println("Reversing link list in groups of k :");
        Node reverseInGroupdOfKHead = list1.reverseInGroupdOfK(3, head1);
        list.display(reverseInGroupdOfKHead);
    }
}
