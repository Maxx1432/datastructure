package Leetcode;

public class LinkedListCycle {

    /*
     * Algorithm: Floyd's Cycle Detection Algorithm (Tortoise and Hare)
     *
     * Logic:
     * 1. Use two pointers: slow (moves 1 step) and fast (moves 2 steps)
     * 2. If there's no cycle, fast pointer will reach null and we return false
     * 3. If there's a cycle, fast pointer will eventually catch up to slow pointer
     * 4. When fast == slow, we've detected a cycle and return true
     *
     * Why this works:
     * - In a cycle, both pointers will eventually enter the cycle
     * - Fast pointer gains 1 position on slow pointer in each iteration
     * - Fast pointer will eventually "lap" the slow pointer within the cycle
     * - The meeting point confirms the existence of a cycle
     *
     * Time Complexity: O(n)
     * - Best case: O(1) if list is empty or has 1 node
     * - Worst case: O(n) where n is number of nodes
     * - In cycle case: fast pointer travels at most 2n steps before meeting slow
     * - In no cycle case: fast pointer reaches end in n/2 steps
     *
     * Space Complexity: O(1)
     * - Only uses two pointer variables (fast, slow)
     * - No additional data structures or recursion
     * - Constant space regardless of input size
     *
     * Example with cycle: [1->2->3->4->5->6->7->1] (7 points back to 1)
     * Step 1: slow=1, fast=1
     * Step 2: slow=2, fast=3
     * Step 3: slow=3, fast=5
     * Step 4: slow=4, fast=7
     * Step 5: slow=5, fast=2 (wrapped around)
     * Step 6: slow=6, fast=4
     * Step 7: slow=7, fast=6
     * Step 8: slow=1, fast=1 -> CYCLE DETECTED!
     */
    public boolean hasCycle(ListNode head) {
        // Initialize both pointers to head
        ListNode fast = head;
        ListNode slow = head;

        // Continue until fast pointer reaches end (no cycle) or meets slow (cycle found)
        while(fast != null && fast.next != null){
            fast = fast.next.next;  // Fast pointer moves 2 steps
            slow = slow.next;       // Slow pointer moves 1 step

            // If pointers meet, cycle is detected
            if(fast == slow)
                return true;
        }

        // Fast pointer reached null, no cycle exists
        return false;
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
        ln7.next = ln1;

        System.out.println("Has Cycle: " + new LinkedListCycle().hasCycle(ln1));
    }
}
