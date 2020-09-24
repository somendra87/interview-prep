package interview.prep.linkedlist;

/**
 * @author somendraprakash created on 09/08/20
 */
public class ReverseBetweenMandN
{
    private static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current = head;
        int i;
        for (i = 0; i < m; i++) {
            current = current.next;
        }
        ListNode temp = current;
        ListNode prev = null;
        ListNode next = null;
        int j = i;
        while (j <= n) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp= next;
            j++;
        }
        return prev;
    }

    private void display(ListNode head){
        ListNode current = head;
        while (current!=null){
            System.out.print(current.val + "\t");
            current = current.next;
        }
    }
    public static void main(String[] args) {
        ReverseBetweenMandN reverseBetweenMandN = new ReverseBetweenMandN();
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(67);
        head.next.next.next.next = new ListNode(21);
        head.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next = new ListNode(56);
        reverseBetweenMandN.display(head);
        System.out.println();
        ListNode reversedHead = reverseBetweenMandN.reverseBetween(head, 2, 6);
        System.out.println("After reversing form m to n ");
        reverseBetweenMandN.display(reversedHead);
    }
}
