package minesweeper.model;

public class NodeMove {

    private Move data;
    private NodeMove next;

    public NodeMove(Move data) {
        this.data = data;
        this.next = null;
    }

    public NodeMove getNext() { return next; }
    public void setNext(NodeMove next) { this.next = next; }
}