class singlyLinkedList {

	//Creating the Head Node
	private ListNode head;
	
	//Creating Node which contain Data and Address of next Node
 private static class ListNode{
		private int data;
		private ListNode next;
		public ListNode(int data) {
			this.data = data;
			//Whenever a new Node added it points to null ByDefault
      this.next = null;
		}
		
	}
	//Creating method to display our List
	public void display() {
		ListNode current  = head;
		
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.print("null");
	}

	private void display(ListNode head) {
		ListNode current  = head;
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.print("null");
	}

 //Insert a Node in the first of List
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head= newNode;
	}

 //Insert the node at last in the list
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		if(head == null) {
			head = newNode;
			return;
		}
		ListNode current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}

 //Insert node at the given position
	public void insertMiddle(int pos, int data) {
		ListNode node = new ListNode(data);
		if(pos == 1) {
			insertFirst(data);
		} else {
			ListNode previous = head;
			int count = 1;
			while (count < pos -1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			node.next = current;
			previous.next = node;
		}
	}

 //delete the First Node in the List
	public ListNode deleteFirst() {
		if(head == null) {
			return null;
		}
	
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}

 //Delete the last node in the list
	public ListNode deleteLast() {
		if(head == null || head.next == null) {
			return null;
		}
		ListNode current = head;
		ListNode previous = null;
		while(current.next!= null)
		{
			previous = current;
			current = current.next;
		}
		previous.next = null;
		return current;
		
	}

 //Delete the Node of the given position
	public void deleteMiddle(int pos) {
		if(pos == 1) {
			head = head.next;
		} else {
			ListNode previous = head;
			int count = 1;
			while(count < pos -1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = current.next;
		}
	}
//Find the element/data in the Singly Linked List
	public boolean find(ListNode head, int searchKey) {
		if(head == null)
			return false;
		ListNode current = head;
		while(current != null) {
			if(current.data == searchKey)
				return true;
			
			current = current.next;
		}
		
		return false;
	}
// Reverse the singly linked list
	public ListNode reverseList() {
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		
		while(current != null)
		{
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		return previous;
	}
// Find the middle element in the singly linked list
	public ListNode findMiddle(ListNode head) {
		if(head == null)
			return null;
		
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		return slowPtr;
	}
// Find the nth node from the end of the singly Linked list
	public ListNode findNthPos(ListNode head, int n)
	{
		if(head == null)
			return null;
		else if(n <= 0) {
			throw new IllegalArgumentException("Invalid Value: n = "+n);
		}
		
		ListNode mainPtr = head;
		ListNode refPtr = head;
		int count = 0;
		
		while(count < n) {
			if(refPtr == null) {
				throw new IllegalArgumentException(n+" is greater than the no. of nodes in list");
			}
			refPtr = refPtr.next;
			count++;
		}
		
		while(refPtr != null)
		{
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		
		return mainPtr;
	}
// Remove the duplicate elemnt from the sorted Singly linked list
	public void removeDuplicate() {
		ListNode current = head;
		while(current != null && current.next != null) {
			if(current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
	}
// Insert in the sorted linked list
	public ListNode insertInSortedList(int data) {
		ListNode newNode = new ListNode(data);
		
		if(head == null)
			return newNode;
		
		ListNode current = head;
		ListNode temp = null;
		
		while(current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}
		
		newNode.next = current;
		temp.next = newNode;
		
		return head;
	}
//	Remove a node by given key
	public void deleteNodeBykey(int key) {
		ListNode current = head;
		ListNode temp = null;
		
		if(current != null && current.data == key ) {
			head = current.next;
			return;
		}
		
		while(current != null && current.data != key)
		{
			temp = current;
			current = current.next;
		}
		
		if(current == null)
		{
			return;
		}
		
		temp.next = current.next;
		return;
		
	}

// Check if linked List contain a Loop or not
public boolean containsLoop() {
		ListNode fstPtr = head;
		ListNode slwPtr = head;
		
		while(fstPtr != null && fstPtr.next != null) {
			fstPtr= fstPtr.next.next;
			slwPtr = slwPtr.next;
			
			if(fstPtr == slwPtr)
				return true;
		}
		
		return false;
	}

// Finding the starting node of singly linked list
private ListNode startingNodeOfLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr.next != null && fastPtr.next.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr)
                return getStartingNode(slowPtr);
        }
        return null;
    }

    private ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;
        while(temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

// remove the loop from singly linked list
private void removeLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                removeLoop(slowPtr);
                return;
            }
        }
    }

    private void removeLoop(ListNode slowPtr) {
        ListNode temp = head;
        while(temp.next != slowPtr.next)
        {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
        return;
    }

// Merge two sorted linked list
public static ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(a != null && b!= null) {
            if(a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }

        return dummy.next;
    }

// Create a loop in Singly Linked List
public void createALoopInLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(6);
        ListNode fourth = new ListNode(2);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(3);
        ListNode seventh = new ListNode(7);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = third;

    }
	
public static void main(String[] args) {
		
//Creating object of our SinglyLinkedList class
    singlyLinkedList sll = new singlyLinkedList();
	//pointing our head.	
  sll.head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode forth = new ListNode(11);
		
		
//		Connect them together to form a chain
		sll.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = null;
		
		sll.display();
		System.out.println();
		
		sll.insertFirst(12);
		sll.display();
		
		sll.insertLast(10);
		System.out.println();
		sll.display();
		
		System.out.println();
		
		sll.insertMiddle(3, 4);
		sll.display();
		
		System.out.println();
		
		sll.insertMiddle(5, 6);
		sll.display();
		
		System.out.println();
		System.out.println(sll.deleteFirst().data);
		
		sll.display();
		
		System.out.println();
		System.out.println(sll.deleteLast().data);
		
		sll.display();
		
		System.out.println();
		sll.deleteMiddle(3);
		
		sll.display();

		sll.display(sll.head);
		System.out.println();
		
//		if(sll.find(sll.head, 12)) {
//			System.out.println("Key Found");
//		} else {
//			System.out.println("key Not Found");
//		}
		
//		ListNode reverse = sll.reverseList();
//		
//		sll.display(reverse);
//		System.out.println();
		
//		System.out.println("Middle Element is :- "+sll.findMiddle(sll.head).data);
//		
//		to find the nth node from the end of singly Linked List
//		
//		System.out.println("nth node from the end is :- "+sll.findNthPos(sll.head,3).data);
		
		sll.insertFirst(10);
		sll.display(sll.head);
		System.out.println();
		
//		Remove duplicate in sorted Singly Linked List
		sll.removeDuplicate();
		sll.display(sll.head);
		System.out.println();
		
		singlyLinkedList sllSorted = new singlyLinkedList();
		sllSorted.insertFirst(16);
		sllSorted.insertFirst(10);
		sllSorted.insertFirst(8);
		sllSorted.insertFirst(1);
		
		
		sllSorted.display(sllSorted.head);
		System.out.println();
		
		sllSorted.insertInSortedList(11);
		
		sllSorted.display(sllSorted.head);
		System.out.println();

		sllSorted.deleteNodeBykey(11);
		sllSorted.display(sllSorted.head);
		System.out.println();

		sll.createALoopInLinkedList();
        	System.out.println(sll.containsLoop());
        	System.out.println(sll.startingNodeOfLoop().data);
        	sll.removeLoop();
        	sll.display();

		// Creating sorted linked list
		singlyLinkedList sortedListA = new singlyLinkedList();
        	sortedListA.insertLast(2);
        	sortedListA.insertLast(4);
        	sortedListA.insertLast(6);

	        // Creating sorted linked list
		singlyLinkedList sortedListB = new singlyLinkedList();
        	sortedListB.insertLast(1);
        	sortedListB.insertLast(3);
        	sortedListB.insertLast(5);
        	sortedListB.insertLast(8);

		singlyLinkedList sortedMergeList = new singlyLinkedList();

        	//Using merge function with return a head and assigning to other list head
		sortedMergeList.head = merge(sortedListA.head,sortedListB.head);
        	System.out.println();

        	sortedMergeList.display();
		
	}


}
