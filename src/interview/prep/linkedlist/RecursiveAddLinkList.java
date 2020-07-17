package interview.prep.linkedlist;

/**
 * @author somendraprakash created on 17/07/20
 */
public class RecursiveAddLinkList
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
        if (head == null) {
            head = new Node(data);
        } else {
            head.link = add(data, head.link);
        }
        return head;
    }

    private void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.link = this.head;
            head = node;
        }
    }


    private void display(Node head) {
        if (head == null) {
            return;
        } else {
            System.out.print(head.data + "\t");
            display(head.link);
        }
    }

    private static Node addRecursive(Node head1, Node head2) {
        //calculate size of first list and second list
        int sizeOfFirstList = 0;
        int sizeOfSecondList = 0;
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null) {
            sizeOfFirstList++;
            temp1 = temp1.link;
        }

        while (temp2 != null) {
            sizeOfSecondList++;
            temp2 = temp2.link;
        }

        RecursiveAddLinkList resultList = new RecursiveAddLinkList();
        int oldCarry = addRecursiveHelper(head1, sizeOfFirstList, head2, sizeOfSecondList, resultList);



        if (oldCarry > 0){
            resultList.addFirst(oldCarry);
        }
        return resultList.head;
    }

    private static int addRecursiveHelper(Node one, int placeValue1, Node two, int placeValue2,
                                          RecursiveAddLinkList resultList) {
        if (one == null && two == null) {
            return 0;
        }
        int sum;
        int oc;
        int newSum;
        int newCarry = 0;
        if (one != null && two != null) {
            if (placeValue1 > placeValue2) {
                oc = addRecursiveHelper(one.link, placeValue1 - 1, two, placeValue2, resultList);
                sum = oc + one.data;
            } else if (placeValue1 < placeValue2) {
                oc = addRecursiveHelper(one, placeValue1, two.link, placeValue2 - 1, resultList);
                sum = oc + two.data;
            } else {
                oc = addRecursiveHelper(one.link, placeValue1 - 1, two.link, placeValue2 - 1, resultList);
                sum = oc + one.data + two.data;
            }
            newSum = sum % 10;
            newCarry = sum / 10;
            resultList.addFirst(newSum);
        }
        return newCarry;
    }


    public static void main(String[] args) {
        RecursiveAddLinkList list1 = new RecursiveAddLinkList();
        Node head1 = null;
        head1 = list1.add(8, head1);
        head1 = list1.add(6, head1);
        head1 = list1.add(9, head1);
        head1 = list1.add(2, head1);
        System.out.println("First list is : ");
        list1.display(head1);
        System.out.println();
        RecursiveAddLinkList list2 = new RecursiveAddLinkList();
        Node head2 = null;
        head2 = list2.add(6, head2);
        head2 = list2.add(4, head2);
        head2 = list2.add(7, head2);
        System.out.println("Second list is : ");
        list2.display(head2);
        System.out.println();

        Node resultListHead = addRecursive(head1, head2);
        RecursiveAddLinkList resultList = new RecursiveAddLinkList();
        System.out.println("Resultant list after performing addition operation : ");
        resultList.display(resultListHead);
        System.out.println();
    }
}
