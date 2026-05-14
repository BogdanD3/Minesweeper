package minesweeper.analysis;

import java.util.Objects;

public class MatchSummary implements Comparable<MatchSummary> {
    private int matchId;
    private String botType;
    private String result;
    private long timeMs;
    private int totalClicks;

    public MatchSummary(int matchId, String botType, String result, long timeMs, int totalClicks) {
        this.matchId = matchId;
        this.botType = botType;
        this.result = result;
        this.timeMs = timeMs;
        this.totalClicks = totalClicks;
    }

    public int getMatchId() { return matchId; }
    public String getBotType() { return botType; }
    public String getResult() { return result; }
    public long getTimeMs() { return timeMs; }
    public int getTotalClicks() { return totalClicks; }

    @Override
    public int compareTo(MatchSummary other) {
        return Long.compare(this.timeMs, other.timeMs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchSummary that = (MatchSummary) o;
        return matchId == that.matchId && timeMs == that.timeMs && totalClicks == that.totalClicks && Objects.equals(botType, that.botType) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, botType, result, timeMs, totalClicks);
    }

    @Override
    public String toString() {
        return "MatchSummary{" +
                "matchId=" + matchId +
                ", botType='" + botType + '\'' +
                ", result='" + result + '\'' +
                ", timeMs=" + timeMs +
                ", totalClicks=" + totalClicks +
                '}';
    }
}
