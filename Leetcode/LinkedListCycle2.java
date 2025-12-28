package Leetcode;

public class LinkedListCycle2 {

    /*
     * Algorithm: Floyd's Cycle Detection Algorithm - Phase II (Finding Cycle Start)
     *
     * Logic:
     * Phase 1: Detect if cycle exists using two-pointer technique
     * 1. Use fast (2 steps) and slow (1 step) pointers
     * 2. If they meet, a cycle exists; if fast reaches null, no cycle
     *
     * Phase 2: Find the start of the cycle
     * 3. Reset slow pointer to head, keep fast at meeting point
     * 4. Move both pointers one step at a time until they meet
     * 5. Meeting point is the start of the cycle
     *
     * Mathematical Proof:
     * Let's say:
     * - L = distance from head to cycle start
     * - C = cycle length
     * - k = distance from cycle start to meeting point
     *
     * When pointers meet in Phase 1:
     * - Slow traveled: L + k
     * - Fast traveled: L + k + nC (where n is number of complete cycles)
     * - Since fast moves 2x speed: 2(L + k) = L + k + nC
     * - Simplifying: L + k = nC, therefore L = nC - k
     *
     * In Phase 2:
     * - Slow starts from head, travels L steps to reach cycle start
     * - Fast starts from meeting point, travels L = nC - k steps
     * - Fast moves: nC - k = (n-1)C + (C - k) steps from meeting point
     * - This lands exactly at cycle start, where they meet!
     *
     * Time Complexity: O(n)
     * - Phase 1: O(n) - fast pointer travels at most 2n steps before meeting slow
     * - Phase 2: O(n) - both pointers travel at most n steps to find cycle start
     * - Total: O(n) + O(n) = O(n)
     *
     * Space Complexity: O(1)
     * - Only uses two pointer variables (fast, slow)
     * - No additional data structures or recursion
     * - Constant space regardless of input size
     *
     * Example: [3->2->0->(-4)->2] (cycle: 2->0->(-4)->2)
     * Phase 1: Pointers meet at node (-4)
     * Phase 2: slow=3, fast=(-4) -> slow=2, fast=2 -> CYCLE START FOUND!
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // Phase 1: Detect cycle using Floyd's algorithm
        // Fast moves 2 steps, slow moves 1 step per iteration
        while(fast != null && fast.next != null){
            slow = slow.next;        // Move slow pointer 1 step
            fast = fast.next.next;   // Move fast pointer 2 steps
            if(slow == fast){        // Cycle detected when pointers meet
                break;
            }
        }

        // If no cycle found (fast reached end), return null
        if(fast == null || fast.next == null)
            return null;

        // Phase 2: Find cycle start node
        // Reset slow to head, keep fast at meeting point
        slow = head;
        while(slow != fast){
            slow = slow.next;    // Move slow pointer 1 step from head
            fast = fast.next;    // Move fast pointer 1 step from meeting point
        }

        // When they meet, it's the start of the cycle
        return slow;
    }

    public static void main(String[] args) {
        // create a linked list with a cycle for testing
        ListNode ln1 = new ListNode(3);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(0);
        ListNode ln4 = new ListNode(-4);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln2; // creates a cycle here
        LinkedListCycle2 solution = new LinkedListCycle2();
        ListNode cycleStart = solution.detectCycle(ln1);
        if(cycleStart != null){
            System.out.println("Cycle detected at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }

        // create a linked list without a cycle for testing
        ListNode ln5 = new ListNode(1);
        ListNode ln6 = new ListNode(2);
        ln5.next = ln6;
        ln6.next = null; // no cycle
        ListNode noCycleStart = solution.detectCycle(ln5);
        if(noCycleStart != null){
            System.out.println("Cycle detected at node with value: " + noCycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
