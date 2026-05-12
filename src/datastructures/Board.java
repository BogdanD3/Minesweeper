package minesweeper.datastructures;

import java.util.Random;
import minesweeper.model.Cell;
import minesweeper.model.CellState;
import minesweeper.model.GameOutcome;

public class Board {
	
    private int size;
    private int numMines;
    private Cell[][] grid;
	
    public Board(int size, int numMines) {
        if (size <= 0 || numMines < 0 || numMines >= size * size) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        this.numMines = numMines;
        grid = new Cell[size][size];
		
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }
		
        Random random = new Random();
        int placedMines = 0;
        while (placedMines < numMines) {
            int randomCol = random.nextInt(size);
            int randomRow = random.nextInt(size);
            if (grid[randomRow][randomCol].isMine()) {
                continue;
            } else {
                grid[randomRow][randomCol].setMine(true);
                placedMines++;
            }
        }
        calculateAdjacentMines();
    }
	
    private void calculateAdjacentMines() {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int count = 0;
                if (!grid[i][j].isMine()) {
                    for (int s = 0; s < 8; s++) {
                        int newRow = i + dx[s];
                        int newCol = j + dy[s];
                        if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                            if (grid[newRow][newCol].isMine()) {
                                count++;
                            }
                        }
                    }
                    grid[i][j].setAdjacentMines(count);
                }
            }
        }
    }
	
    public void revealCell(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) return;
        if (grid[row][col].getState() != CellState.HIDDEN) return;
        
        grid[row][col].setState(CellState.REVEALED);
        
        if (grid[row][col].isMine() || grid[row][col].getAdjacentMines() > 0) return;

        CoordinateQueue queue = new CoordinateQueue();
        queue.enqueue(row, col);

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!queue.isEmpty()) {
            int currentRow = queue.peekRow();
            int currentCol = queue.peekCol();
            queue.dequeue();

            for (int s = 0; s < 8; s++) {
                int newRow = currentRow + dx[s];
                int newCol = currentCol + dy[s];
                if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                    if (grid[newRow][newCol].getState() == CellState.HIDDEN) {
                        if (!grid[newRow][newCol].isMine()) {
                            grid[newRow][newCol].setState(CellState.REVEALED);
                            if (grid[newRow][newCol].getAdjacentMines() == 0) {
                                queue.enqueue(newRow, newCol);
                            }
                        }
                    }
                }
            }
        }
    }
	
    public GameOutcome getGameState() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].isMine() && grid[i][j].getState() == CellState.REVEALED) {
                    return GameOutcome.DEFEAT;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!grid[i][j].isMine() && grid[i][j].getState() != CellState.REVEALED) {
                    return GameOutcome.IN_PROGRESS;
                }
            }
        }
        return GameOutcome.VICTORY;
    }
}