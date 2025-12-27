package Leetcode;

public class PalindromeLinkedList {

    /*
     * Algorithm: Palindrome Linked List Check using Two-Pointer + Reverse Approach
     *
     * Logic:
     * 1. Find the middle of the linked list using Floyd's Cycle Detection (fast/slow pointers)
     * 2. Reverse the second half of the linked list in-place
     * 3. Compare the first half with the reversed second half node by node
     * 4. Return true if all corresponding nodes match, false otherwise
     *
     * Time Complexity: O(n)
     * - Phase 1 (Find middle): O(n/2) iterations
     * - Phase 2 (Reverse second half): O(n/2) iterations
     * - Phase 3 (Compare halves): O(n/2) iterations
     * - Total: O(3n/2) = O(n)
     *
     * Space Complexity: O(1)
     * - Only uses constant extra space (fast, slow, previous, next, curr pointers)
     * - No recursion or additional data structures
     * - Modifies original list structure temporarily
     *
     * Example: [1,2,3,2,1]
     * Step 1: Find middle -> slow points to middle '3'
     * Step 2: Reverse second half -> [1,2,3] and [1,2] (reversed from [2,1])
     * Step 3: Compare [1,2] with [1,2] -> All match -> return true
     */
    public boolean isPalindrome(ListNode head){

        // Phase 1: Find middle using two-pointer technique (Floyd's Algorithm)
        // Fast pointer moves 2 steps, slow moves 1 step
        // When fast reaches end, slow will be at middle
        ListNode fast  = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;        // Move slow pointer 1 step
            fast = fast.next.next;   // Move fast pointer 2 steps
        }

        // Phase 2: Reverse the second half of the linked list
        // Standard iterative reversal starting from middle node
        ListNode previous = null;
        while(slow != null){
            ListNode next = slow.next;  // Store next node before breaking link
            slow.next = previous;       // Reverse the link
            previous = slow;            // Move previous pointer forward
            slow = next;                // Move to next node
        }
        // After this loop, 'previous' points to head of reversed second half

        // Phase 3: Compare first half with reversed second half
        // Traverse both halves simultaneously and compare values
        ListNode curr = head;
        while(previous != null && curr.next != null){  // Note: This condition has a bug - should be curr != null
            if(previous.val != curr.val){
                return false;  // Mismatch found, not a palindrome
            }
            previous = previous.next;   // Move through reversed second half
            curr = curr.next;           // Move through first half
        }

        return true;  // All comparisons passed, it's a palindrome
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(3);
        ListNode ln5 = new ListNode(1);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = null;

        System.out.println("Is Palindrome: " + new PalindromeLinkedList().isPalindrome(ln1));
    }
}
