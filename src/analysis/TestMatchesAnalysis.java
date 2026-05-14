package minesweeper.analysis;

import java.io.IOException;

public class TestMatchesAnalysis {

    public static void main(String[] args) throws IOException {

        MatchDataset dataset = MatchFactory.parseFile("matches.csv");

        System.out.println("=== Telemetry Report ===");
        System.out.println();

        Double avgVictory = dataset.getAverageClicksByResult("VICTORY");
        System.out.println("Average clicks in VICTORY: " + avgVictory);

        Double avgDefeat = dataset.getAverageClicksByResult("DEFEAT");
        System.out.println("Average clicks in DEFEAT:  " + avgDefeat);

        System.out.println();

        MatchSummary fastest = dataset.getMatchWithHighestClickRate();
        System.out.println("Match with highest click rate:");
        System.out.println("  Match ID:     " + fastest.getMatchId());
        System.out.println("  Bot type:     " + fastest.getBotType());
        System.out.println("  Result:       " + fastest.getResult());
        System.out.println("  Time (ms):    " + fastest.getTimeMs());
        System.out.println("  Total clicks: " + fastest.getTotalClicks());
    }
}