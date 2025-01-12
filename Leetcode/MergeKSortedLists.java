package Leetcode;

public class MergeKSortedLists {
    public static ListNode mergeList(ListNode head1, ListNode head2){
        if(head2 == null){
            return head1;
        }
        ListNode currentHead = new ListNode(Integer.MIN_VALUE);
        ListNode temp = currentHead;
        while(head1 != null && head2 != null){
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 != null)
            temp.next = head1;
        if (head2 != null)
            temp.next = head2;

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

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        ListNode currentHead = new ListNode(Integer.MIN_VALUE);

        for(ListNode head : lists){
            currentHead = mergeList(currentHead, head);
        }

        return currentHead.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeLists = new MergeKSortedLists();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = null;

        ListNode ln5 = new ListNode(1);
        ListNode ln6 = new ListNode(2);
        ListNode ln7 = new ListNode(3);
        ListNode ln8 = new ListNode(4);
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = null;

        ListNode [] listArray = new ListNode[2];
        listArray[0] = ln1;
        listArray[1] = ln5;
        display(ln1);
        System.out.println();
        display(ln5);
        System.out.println();
        display(mergeLists.mergeKLists(listArray));

    }
}
