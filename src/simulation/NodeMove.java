package minesweeper.model;

public class NodeMove {

    private Move data;
    private NodeMove next;

    public NodeMove(Move data) {
        this.data = data;
        this.next = null;
    }

}