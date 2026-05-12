package minesweeper.simulation;

import minesweeper.datastructures.Board;
import minesweeper.model.GameOutcome;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GamesSimulator {

    private static final int BOARD_SIZE   = 8;
    private static final int NUM_MINES    = 6;
    private static final int NUM_MATCHES  = 1000;
    private static final String BOT_TYPE  = "RandomBot";
    private static final String CSV_PATH  = "matches.csv";

    public static Player createBot(Board board) {
        return new Player(board);
    }

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_PATH))) {

            writer.write("MatchId,BotType,Result,TimeMs,TotalClicks");
            writer.newLine();

            for (int matchId = 1; matchId <= NUM_MATCHES; matchId++) {

                Board board   = new Board(BOARD_SIZE, NUM_MINES);
                Player bot    = createBot(board);

                long startTime = System.currentTimeMillis();

                GameOutcome outcome = GameOutcome.IN_PROGRESS;
                while (outcome == GameOutcome.IN_PROGRESS) {
                    outcome = bot.playTurn();
                }

                long timeMs = System.currentTimeMillis() - startTime;

                int totalClicks = bot.getMoveHistory().size();

                String result = (outcome == GameOutcome.VICTORY) ? "VICTORY" : "DEFEAT";

                writer.write(matchId + "," + BOT_TYPE + "," + result + "," + timeMs + "," + totalClicks);
                writer.newLine();
            }

            System.out.println("Simulation complete. Results written to: " + CSV_PATH);

        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}
