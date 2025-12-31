package Leetcode;

/*
 * Algorithm: Design Linked List - Custom Singly Linked List Implementation
 *
 * Logic:
 * This implementation provides a singly linked list with the following operations:
 * 1. get(index) - Get value at specific index
 * 2. addAtHead(val) - Add node at beginning
 * 3. addAtTail(val) - Add node at end
 * 4. addAtIndex(index, val) - Add node at specific index
 * 5. deleteAtIndex(index) - Delete node at specific index
 *
 * Data Structure Design:
 * - Uses Node class with val and next pointer
 * - Maintains head, tail pointers and size counter for O(1) operations where possible
 * - Head pointer: Points to first node for efficient front operations
 * - Tail pointer: Points to last node for efficient rear operations
 * - Size counter: Tracks number of nodes for boundary checks and tail operations
 */
class MyLinkedList {

    /*
     * Node Structure:
     * Each node contains:
     * - val: integer value stored in the node
     * - next: reference to the next node in the list
     */
    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head = null;  // Points to first node
    Node tail = null;  // Points to last node
    int size = 0;      // Tracks number of nodes

    /*
     * Constructor: Initialize empty linked list
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public MyLinkedList() {

    }

    /*
     * Get value at specific index
     *
     * Logic:
     * 1. Validate index bounds (return -1 if invalid)
     * 2. Traverse from head to target index using loop
     * 3. Return value at target node
     *
     * Time Complexity: O(n) where n is the index
     * - Worst case: O(size) when index = size-1
     * - Best case: O(1) when index = 0
     *
     * Space Complexity: O(1)
     * - Only uses constant extra space (temp pointer)
     */
    public int get(int index) {
        if (index >= size)
            return -1;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    /*
     * Helper method: Get node reference at specific index
     *
     * Logic:
     * 1. Validate index bounds (return null if invalid)
     * 2. Traverse from head to target index using loop
     * 3. Return node reference at target position
     *
     * Time Complexity: O(n) where n is the index
     * - Worst case: O(size) when index = size-1
     * - Best case: O(1) when index = 0
     *
     * Space Complexity: O(1)
     * - Only uses constant extra space (temp pointer)
     */
    public Node getNode(int index) {
        if (index >= size)
            return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /*
     * Add new node at the beginning (head) of the list
     *
     * Logic:
     * 1. Create new node with given value
     * 2. Set new node's next to current head
     * 3. Update head to point to new node
     * 4. If list was empty, update tail to point to new node
     * 5. Increment size counter
     *
     * Time Complexity: O(1)
     * - Direct pointer manipulation, no traversal needed
     *
     * Space Complexity: O(1)
     * - Only creates one new node, constant space
     */
    public void addAtHead(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        if (size == 0)
            tail = head;
        size++;
    }

    /*
     * Add new node at the end (tail) of the list
     *
     * Logic:
     * 1. If list is empty, call addAtHead() (reuse logic)
     * 2. Otherwise, create new node and link from current tail
     * 3. Update tail pointer to new node
     * 4. Increment size counter
     *
     * Time Complexity: O(1)
     * - Uses tail pointer for direct access to end
     * - No traversal needed due to tail pointer maintenance
     *
     * Space Complexity: O(1)
     * - Only creates one new node, constant space
     */
    public void addAtTail(int val) {
        if (size == 0)
            addAtHead(val);
        else {
            tail.next = new Node(val);
            tail = tail.next;
            size++;
        }
    }

    /*
     * Add new node at specific index
     *
     * Logic:
     * 1. Validate index bounds (return if index > size)
     * 2. If index = 0, call addAtHead() (reuse logic)
     * 3. If index = size, call addAtTail() (reuse logic)
     * 4. Otherwise, traverse to node at (index-1)
     * 5. Create new node and insert between (index-1) and index
     * 6. Update next pointers to maintain list integrity
     * 7. Increment size counter
     *
     * Time Complexity: O(n) where n is the index
     * - Best case: O(1) when index = 0 or index = size
     * - Worst case: O(size) when index is in middle
     *
     * Space Complexity: O(1)
     * - Only creates one new node, constant space
     */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index == 0) {
            addAtHead(val);
        } else if (index == size)
            addAtTail(val);
        else {
            Node temp = new Node(val);
            Node preNode = getNode(index - 1);
            temp.next = preNode.next;
            preNode.next = temp;
            size++;
        }
    }

    /*
     * Delete node at specific index
     *
     * Logic:
     * 1. Validate index bounds (return if invalid)
     * 2. If index = 0 (delete head):
     *    - Update head to head.next
     *    - If only one node, update tail to null
     * 3. Otherwise (delete middle/tail):
     *    - Traverse to node at (index-1)
     *    - Skip the target node by updating next pointer
     *    - If deleting tail, update tail pointer
     * 4. Decrement size counter
     *
     * Time Complexity: O(n) where n is the index
     * - Best case: O(1) when index = 0
     * - Worst case: O(size) when index = size-1
     *
     * Space Complexity: O(1)
     * - Only uses constant extra space (temp pointer)
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            head = head.next;
            if (size == 1) tail = null;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (index == size - 1) tail = temp;
        }
        size--;
    }
}

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3

        System.out.println(myLinkedList.get(1));  // expected: 2

        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3

        System.out.println(myLinkedList.get(1));  // expected: 3             // return 3
    }
}
