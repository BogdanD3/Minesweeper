package minesweeper.analysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MatchFactory {
    
    public static MatchSummary parseMatchFromCsvLine(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            throw new IllegalArgumentException("CSV data line is empty.");
        }

        String[] parts = csvLine.split(",");
        
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid CSV format.");
        }

        try {
            int matchId = Integer.parseInt(parts[0].trim());
            String botType = parts[1].trim();
            String result = parts[2].trim();
            long timeMs = Long.parseLong(parts[3].trim());
            int totalClicks = Integer.parseInt(parts[4].trim());

            return new MatchSummary(matchId, botType, result, timeMs, totalClicks);
            
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error parsing numeric data in CSV line: " + csvLine, e);
        }
    } 

    public static MatchDataset parseFile(String path) throws IOException {
        MatchDataset dataset = new MatchDataset();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.readLine(); // preskoči header red
            String line;
            while ((line = reader.readLine()) != null) {
                dataset.addMatch(parseMatchFromCsvLine(line));
            }
        }
        return dataset;
    }
}
