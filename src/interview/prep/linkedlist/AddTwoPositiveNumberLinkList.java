package interview.prep.linkedlist;

/**
 * @author somendraprakash created on 16/07/20
 */
public class AddTwoPositiveNumberLinkList
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

    private ListNode sumTwoList(ListNode head1, ListNode head2) {
        // Given is the two list we need to find the sum of the list and return the result list

        //assuming result list head as null
        ListNode resultHead = null;
        // sum = carry + data1 + data2 , initializing carry to 0
        int carry = 0;

        // initializing sum to 0
        int sum ;

        //taking a previous node and initializing to null
        ListNode prev = null;

        // Iterate over
        while (head1 != null || head2 != null) {
            sum = carry + (head1 != null ? head1.data : 0)
                    + (head2 != null ? head2.data : 0);

            carry = sum / 10;
            sum = sum % 10;
            ListNode resultNode = new ListNode(sum);
            if (resultHead == null) {
                resultHead = resultNode;
            } else {
                prev.link = resultNode;
            }
            prev = resultNode;

            if (head1 != null) {
                head1 = head1.link;
            }
            if (head2 != null) {
                head2 = head2.link;
            }

            if (carry != 0) {
                prev.link = new ListNode(carry);
            }
        }
        return resultHead;
    }

    private ListNode reverse(ListNode resultHead) {
        ListNode next ;
        ListNode prev = null;

        while (resultHead != null) {
            next = resultHead.link;
            resultHead.link = prev;
            prev = resultHead;
            resultHead = next;
        }
        return prev;
    }

    private ListNode addNode(int data, ListNode head) {
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
        return node;
    }

    private void display(ListNode head){
        while (head!=null){
            System.out.print(head.data +"\t");
            head = head.link;
        }
    }

    public static void main(String[] args) {
        AddTwoPositiveNumberLinkList list1 = new AddTwoPositiveNumberLinkList();
        ListNode head1 = null;
        ListNode temp1;
        temp1 = list1.addNode(5, head1);
        temp1.link = list1.addNode(7, head1);
        temp1.link.link = list1.addNode(9, head1);
        head1 = temp1;
        System.out.println("First List is : ");
        list1.display(head1);
        System.out.println();
        System.out.println("Reverse of First list is :");
        ListNode reverseHead1 = list1.reverse(head1);
        list1.display(reverseHead1);
        System.out.println();


        AddTwoPositiveNumberLinkList list2 = new AddTwoPositiveNumberLinkList();
        ListNode head2 = null;
        ListNode temp2;
        temp2 = list2.addNode(8, head2);
        temp2.link = list2.addNode(7, head2);
        temp2.link.link = list2.addNode(8, head2);
        head2 = temp2;
        System.out.println("Second list is : ");
        list2.display(head2);
        System.out.println();

        System.out.println("Reverse of second list is : ");
        ListNode reverseHead2 = list2.reverse(head2);
        list2.display(reverseHead2);
        System.out.println();

        AddTwoPositiveNumberLinkList sumList = new AddTwoPositiveNumberLinkList();
        ListNode sumHead = sumList.sumTwoList(reverseHead1, reverseHead2);
        sumHead = sumList.reverse(sumHead);
        System.out.println("Sum list is : ");
        sumList.display(sumHead);
        System.out.println();
    }
}
