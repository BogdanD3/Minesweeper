package minesweeper.analysis;

import java.util.*;

public class MatchDataset {

    private SortedSet<MatchSummary> matches;

    public MatchDataset() {
        this.matches = new TreeSet<>();
    }

    public void addMatch(MatchSummary match) {
        matches.add(match);
    }

    public Double getAverageClicksByResult(String result) {
        return matches.stream()
                .filter(m -> m.getResult().equals(result))
                .mapToInt(m -> m.getTotalClicks())
                .average()
                .orElse(0.0);
    }

    public MatchSummary getMatchWithHighestClickRate() {
        return matches.stream()
                .max(Comparator.comparing(m -> (double) m.getTotalClicks() / Math.max(m.getTimeMs(), 1)))
                .orElse(null);
    }
}