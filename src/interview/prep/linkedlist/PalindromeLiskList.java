package interview.prep.linkedlist;

/**
 * @author somendraprakash created on 15/07/20
 */
public class PalindromeLiskList
{
    private static class ListNode
    {
        int data;
        ListNode link;

        ListNode(int data) {
            this.data = data;
            this.link = null;
        }
    }

    private ListNode head;

    private void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = node;
        }
    }

    private boolean isListPalindrome() {
        ListNode slow = this.head;
        ListNode fast = this.head;
        ListNode mid ;
        if (this.head == null) {
            return false;
        } else {
            // find mid of the list
            while(fast != null && fast.link != null){
                fast = fast.link.link;
                slow = slow.link;
            }
            // check for even or odd criteria
            // if odd : move midOfTheList one position ahead
            // else if even : do not move
            if (fast != null){ // if fast != nul then list is odd hence move slow one position ahead
                mid = slow.link;
            }else{
                mid = slow;
            }

            // reverse second half of the list
            // for second half head will be midOfThelist and tail will be null
            ListNode prev = null;
            ListNode next ;

            while (mid != null) {
                next = mid.link;
                mid.link = prev;
                prev = mid;
                mid = next;
            }
            ListNode midHead = prev;
            ListNode temp = this.head;
            // now compare the nodes from head to mid and from mid+1 to end of the list
            while (temp!=null &&  midHead != null) {
                if (temp.data != midHead.data){
                    return false;
                }else{
                    midHead = midHead.link;
                    temp = temp.link;
                }
            }
            return true;
        }
    }

    private void displayList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.link;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PalindromeLiskList lsit = new PalindromeLiskList();
        lsit.addLast(1);
        lsit.addLast(2);
        lsit.addLast(3);
        lsit.addLast(4);
        lsit.addLast(3);
        lsit.addLast(2);
        lsit.addLast(1);
        lsit.displayList();
        System.out.println(lsit.isListPalindrome());
    }
}
