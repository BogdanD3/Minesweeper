package minesweeper.simulation;

import minesweeper.datastructures.Board;
import minesweeper.model.CellState;
import minesweeper.model.GameOutcome;
import java.util.Random;

public class Player {
    private final Board board;
    private final MyLinkedList moveHistory;
    private final Random rng;

    public Player(Board board) {
        this.board = board;
        this.moveHistory = new MyLinkedList();
        this.rng = new Random();
    }

    public GameOutcome playTurn() {
    int size = board.getSize();
    int chosenRow = -1, chosenCol = -1;
    int seen = 0;

    for (int r = 0; r < size; r++) {
        for (int c = 0; c < size; c++) {
            if (board.getCell(r, c).getState() == CellState.HIDDEN) {
                seen++;
                if (rng.nextInt(seen) == 0) {
                    chosenRow = r;
                    chosenCol = c;
                }
            }
        }
    }

    if (chosenRow == -1) return board.getGameState();

    boolean isMine = board.getCell(chosenRow, chosenCol).isMine();
    board.revealCell(chosenRow, chosenCol);
    moveHistory.insert(new Move(chosenRow, chosenCol, !isMine));

    return board.getGameState();
}

    public MyLinkedList getMoveHistory() {
        return moveHistory;
    }

    public Board getBoard() {
        return board;
    }
}
