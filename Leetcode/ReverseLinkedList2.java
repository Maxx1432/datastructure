package Leetcode;

/**
 * LeetCode Problem: Reverse Linked List II (https://leetcode.com/problems/reverse-linked-list-ii/)
 *
 * Problem: Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * Approach: One-pass iterative reversal using dummy node
 * 1. Create a dummy node to handle edge cases (when left = 1)
 * 2. Find the node just before the left position
 * 3. Reverse the sublist from left to right using iterative pointer manipulation
 * 4. Connect the reversed sublist back to the original list
 *
 * Time Complexity: O(n) - where n is the number of nodes in the linked list
 *                  We traverse the list once to find the left position and once to reverse the sublist
 *
 * Space Complexity: O(1) - only using a constant amount of extra space for pointers
 */
public class ReverseLinkedList2 {
    /**
     * Reverses nodes of a linked list from position left to position right.
     *
     * Algorithm Explanation:
     * =====================
     * Example: 1 -> 2 -> 3 -> 4 -> 5, left=2, right=4
     * Goal: 1 -> 4 -> 3 -> 2 -> 5
     *
     * Step 1: Create dummy node and find prev (node before left position)
     *   dummy -> 1 -> 2 -> 3 -> 4 -> 5
     *   prev points to 1 (node before position 2)
     *
     * Step 2: Initialize pointers
     *   curr = 2 (first node to reverse)
     *   We'll perform (right-left) = 2 iterations
     *
     * Step 3: Iterative reversal process
     *   Iteration 1: Move node 3 to front
     *   Before: 1 -> 2 -> 3 -> 4 -> 5
     *   After:  1 -> 3 -> 2 -> 4 -> 5
     *
     *   Iteration 2: Move node 4 to front
     *   Before: 1 -> 3 -> 2 -> 4 -> 5
     *   After:  1 -> 4 -> 3 -> 2 -> 5
     *
     * Time Complexity: O(n) where n is the number of nodes
     *   - O(left) to find the starting position
     *   - O(right-left) for the reversal process
     *   - Overall: O(n) in worst case when left=1 and right=n
     *
     * Space Complexity: O(1) - Only using constant extra space for pointers
     *   - dummy, prev, curr, next pointers
     *   - No recursion or additional data structures
     *
     * @param head The head of the linked list
     * @param left The left boundary (1-indexed)
     * @param right The right boundary (1-indexed)
     * @return The head of the modified list
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Base case: if head is null or left equals right, no reversal needed
        // Edge case handling for invalid inputs
        if(head == null || left == right)
            return head;

        // Create dummy node to handle edge case when left = 1
        // This simplifies the logic by ensuring we always have a node before the reversal section
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Find the node just before the left position
        // We need this to reconnect the reversed section back to the list
        ListNode prev = dummy;
        for(int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Initialize pointers for reversal
        ListNode curr = prev.next;  // First node to be reversed (at position 'left')
        ListNode next;              // Temporary pointer for the reversal process

        // Step 3: Reverse the sublist from left to right using iterative approach
        // We need to perform (right - left) swaps to reverse the section
        // In each iteration, we move the next node to the front of the reversed section
        for(int i = 0; i < right - left; i++){
            next = curr.next;           // Store the next node to be moved
            curr.next = next.next;      // Remove 'next' from its current position
            next.next = prev.next;      // Insert 'next' at the beginning of reversed section
            prev.next = next;           // Update prev to point to the newly moved node

            // Visualization of one iteration:
            // Before: prev -> curr -> next -> remaining
            // After:  prev -> next -> curr -> remaining
        }

        // Return the head of the modified list (dummy.next handles edge case when left=1)
        return dummy.next;
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
        ListNode head = new ReverseLinkedList2().reverseBetween(ln1, 2, 6);
        display(head);
    }
}
