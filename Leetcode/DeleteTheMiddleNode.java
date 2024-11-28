package Leetcode;
public class DeleteTheMiddleNode {
    public static ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            head = null;
            return head;
        }

        // if(head.next.next == null){
        //     head.next = null;
        //     return head;
        // }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = slow.next.next;
        temp.next = null;
        return head;
    }

    private static void display(ListNode head) {
        ListNode current  = head;
        while(current != null) {
            System.out.print(current.val + " --> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln7 = new ListNode(7);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = null;

        display(ln1);
        System.out.println();
        ListNode head = deleteMiddle(ln1);
        display(head);
    }

}
