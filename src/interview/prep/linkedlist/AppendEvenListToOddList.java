package interview.prep.linkedlist;

/**
 * @author somendraprakash created on 18/07/20
 */
public class AppendEvenListToOddList
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

    private Node head;

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

    private Node linkOddEvenElementsIntoOneListPreservingTheInsersionOrder(Node head) {
        Node evenHead = new Node(-2);
        Node oddHead = new Node(-1);
        Node evenTail = evenHead;
        Node oddTail = oddHead;
        Node current = head;

        while (current != null) {
            if (current.data % 2 != 0) {
                oddTail.link = current;
                oddTail = oddTail.link;
            } else {
                evenTail.link = current;
                evenTail = evenTail.link;
            }
            current = current.link;
        }
        oddTail.link = evenHead.link;
        evenTail.link = null;
        return oddHead.link;
    }

    private void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.link;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AppendEvenListToOddList list1 = new AppendEvenListToOddList();
        Node head = null;
        head = list1.add(11, head);
        head = list1.add(18, head);
        head = list1.add(21, head);
        head = list1.add(9, head);
        head = list1.add(6, head);
        head = list1.add(37, head);
        head = list1.add(22, head);
        head = list1.add(21, head);

        list1.display(head);

        System.out.println("seggregating odd and even lists from the given list : ");
        Node findalHead = list1.linkOddEvenElementsIntoOneListPreservingTheInsersionOrder(head);
        list1.display(findalHead);

    }
}
