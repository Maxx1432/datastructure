public class singlyLinkedList {

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
		
	}

}
