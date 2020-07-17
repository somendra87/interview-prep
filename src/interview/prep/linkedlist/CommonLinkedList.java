package interview.prep.linkedlist;

/**
 * @author somendraprakash created on 12/07/20
 */
public class CommonLinkedList
{
    static class LNode
    {
        int data;
        LNode link;

        LNode(int data) {
            this.data = data;
            this.link = null;
        }
    }

    // summary object
    private LNode head;

    // addFirst()
    private void addFirst(int data) {
        LNode node = new LNode(data);
        if (this.head == null) {
            head = node;
        } else {
            node.link = this.head;
            this.head = node;
        }
    }

    // add last
    void addLast(int data) {
        LNode node = new LNode(data);
        if (this.head == null) {
            this.head = node;
        } else {
            LNode temp = this.head;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = node;
        }
    }

    // add at
    private void addAt(int data, int position) {
        //crate a node to insert
        LNode node = new LNode(data);

        //reach to the point -> index - 1
        LNode temp = this.head;
        int index = 0;
        if (position == 0) {
            addFirst(data);
        } else {
            while (index < position - 1) {
                temp = temp.link;
                index++;
            }
            node.link = temp.link;
            temp.link = node;
        }
    }

    // delete at the beginning
    private void deleteFist() {
        if (this.head == null) {
            System.out.println("List is empty , cannot perform delete operation");
        } else {
            LNode temp = this.head;
            System.out.println(temp.data + " is deleted from the list .");
            temp = temp.link;
            this.head = temp;
        }
    }

    // delete at last of the list
    private void deleteLast() {
        LNode temp = this.head;
        LNode prev = null;
        if (this.head == null) {
            System.out.println("List is empty , cannot perform delete operation.");
        } else {
            while (temp.link != null) {
                prev = temp;
                temp = temp.link;
            }
            if (prev != null) {
                prev.link = null;
            }
        }
    }

    // delete at postition
    private void deleteAt(int position) {
        if (this.head == null) {
            System.out.println("List is empty , cannot perform delete operation.");
        } else {
            LNode temp = this.head;
            LNode prev = null;

            for (int i = 0; i < position; i++) {
                prev = temp;
                temp = temp.link;
            }
            if (prev != null) {
                prev.link = temp.link;
                temp.link = null;
            }

        }
    }

    // size of the link list
    private int size() {
        int count = 0;
        if (this.head == null) {
            return 0;
        } else {
            LNode temp = this.head;
            while (temp.link != null) {
                temp = temp.link;
                count++;
            }
        }
        return count;
    }

    // reverse link list iteratively
    private void reverseLink() {
        LNode current = this.head;
        LNode next;
        LNode prev = null;

        //Two pointer approach
        if (current == null) {
            System.out.println("List is empty , cannot perform reverse operation.");
        } else {
            while (current != null) {
                next = current.link;
                current.link = prev;
                prev = current;
                current = next;
            }
        }
        this.head = prev;
    }

    // check if the link list is palindrome
    boolean isListPalindrome() {
        /**
         * find mid
         * reverse the send half
         * get size of the list
         * check for even odd number of element
         */

        return false;
    }

    private void checkEvenOrOddNumberOfNodes() {
        LNode fast = head;
        LNode slow = head;

        int count = 0;
        while (fast != null && fast.link != null) {
            fast = fast.link.link;
            slow = slow.link;
            count++;
            if (fast == null) {
                System.out.println("even number of nodes : " + count);
            }
        }
    }

    void displayList() {
        LNode temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.link;
        }
    }

    public static void main(String[] args) {
        CommonLinkedList list = new CommonLinkedList();
        for (int i = 0; i < 7; i++) {
            list.addFirst(i + (i + 10));
        }
        System.out.println("List created by addFirst : ");
        list.displayList();
        System.out.println("\n");
        System.out.println("List created by addLast: ");
        for (int i = 5; i < 9; i++) {
            list.addLast(i + (i + 4));
        }
        list.displayList();
        System.out.println("\n");
        System.out.println("Insert an element at the given position in the list : ");
        list.addAt(900, 4);
        list.displayList();
        System.out.println("\n");

        System.out.println("Delete at first position in  the list : ");
        list.deleteFist();
        list.displayList();
        System.out.println("\n");

        System.out.println("Delete af last position in the list :  ");
        list.deleteLast();
        list.displayList();
        System.out.println("\n");

        System.out.println("Delete at the given position in the list : ");
        list.deleteAt(4);
        list.displayList();
        System.out.println("\n");

        System.out.println("Reverse the list : ");
        list.reverseLink();
        list.displayList();
        System.out.println("\n");
        System.out.println("Size of the list is : " + list.size());

        list.addLast(40);
        list.checkEvenOrOddNumberOfNodes();
    }
}
