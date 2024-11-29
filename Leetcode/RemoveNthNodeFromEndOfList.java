package Leetcode;

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // solution with two pass
        // int listLength = 0;
        // ListNode current = head;

        // while(current != null){
        //     current = current.next;
        //     listLength++;
        // }

        // if(listLength == n)
        //     return head.next;

        // int counter = 0;
        // current = head;
        // while(n != listLength - counter - 1){
        //     current = current.next;
        //     counter++;
        // }
        // current.next = current.next.next;
        // return head;

        //solution with two pass

        ListNode currentHead = new ListNode(0);
        currentHead.next = head;
        ListNode slow = currentHead;
        ListNode fast = currentHead;

        while(fast != null && fast.next != null){
            if(n != 0){
                fast = fast.next;
                n--;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        slow.next = slow.next.next;
        return currentHead.next;
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
        ListNode head = removeNthFromEnd(ln1 , 2);
        display(head);
    }
}
