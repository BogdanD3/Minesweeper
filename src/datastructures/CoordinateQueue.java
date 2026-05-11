package datastructures;

public class CoordinateQueue {
	
	private static class CoordinateNode {
	
		int row;
		int col;
		CoordinateNode next;
		
		public CoordinateNode (int row, int col) {
			this.row = row;
			this.col = col;
			this.next = null;
		}
	}
	
	private CoordinateNode head;
	private CoordinateNode tail;
	
	public boolean isEmpty () {
		
		if (head == null) {
			return true;
		}
		
		return false;		
	}
	
	public void enqueue (int row, int col) {
		
		CoordinateNode newNode = new CoordinateNode (row, col);
		
		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public int peekRow () {
		return head.row;
	}
	
	public int peekCol() {
		return head.col;
	}
	
	public void dequeue() {
		
		if (head == null) {
			return;
		}
		
		else if (head.next == null) {
			head = tail = null;
			return;
		}
		else {
			head = head.next;
		}
	}	
}

