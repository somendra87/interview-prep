package interview.prep.linkedlist;

import interview.prep.linkedlist.CommonLinkedList.LNode;

/**
 * @author somendraprakash created on 12/07/20
 */
public class ReverserLinkListIterative
{
    LNode reverseLink(LNode head) {
        LNode current = head;
        LNode next ;
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
        return prev;
    }

    public static void main(String[] args) {
        ReverserLinkListIterative rrlItr = new ReverserLinkListIterative();
        CommonLinkedList ll = new CommonLinkedList();
        ll.addLast(10);
        ll.addLast(80);
        ll.addLast(30);
        ll.addLast(90);
        ll.addLast(50);
        ll.addLast(70);
        System.out.println("Original List : ");
        ll.displayList();
        System.out.println("\n");
        System.out.println("List after reversing : ");
        ll.displayList();
    }
}
