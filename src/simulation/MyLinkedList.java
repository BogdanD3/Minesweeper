package minesweeper.model;

public class MyLinkedList {

    private NodeMove head;

    public MyLinkedList() {
        this.head = null;
    }

    public void insert(Move move) {
        NodeMove newNode = new NodeMove(move);
        if (head == null) { head = newNode; return; }
        NodeMove current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public int size() {
        int count = 0;
        NodeMove current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public NodeMove getHead() {
        return head;
    }
    
}