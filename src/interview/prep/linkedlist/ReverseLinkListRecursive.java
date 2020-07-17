package interview.prep.linkedlist;

/**
 * @author somendraprakash created on 12/07/20
 */
public class ReverseLinkListRecursive
{
    private class MyNode
    {
        int data;
        MyNode next;

        MyNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //summary object
    private MyNode head;

    private void add(int data) {
        MyNode node = new MyNode(data);
        if (this.head == null) {
            this.head = node;
        } else {
            MyNode temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    private void reverseListRecursive(){
        MyNode node = reverseListRecursively(head);
        display(node);
    }

    private MyNode reverseListRecursively(MyNode head){
        if (head==null || head.next == null){
            return head;
        }
        MyNode restOfList = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return restOfList;
    }

    private void display(){
        display(head);
    }

    private void display(MyNode head) {
        MyNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print(" null");
    }

    public static void main(String[] args) {
        ReverseLinkListRecursive rrl = new ReverseLinkListRecursive();
        rrl.add(10);
        rrl.add(20);
        rrl.add(30);
        rrl.add(40);
        rrl.add(50);
        rrl.add(60);
        rrl.add(70);
        System.out.println("original list: ");
        rrl.display();
        System.out.println();
        System.out.println("Link List after reversing: ");
        rrl.reverseListRecursive();
    }
}
