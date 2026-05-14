# Minesweeper Project
Collaborative project between University of Montenegro (PMF) and University of Seville.

---

## How to Run

### 1. Compile

### 2. Run the Simulator
Generates `matches.csv` with 1000 automated matches.

### 3. Run the Analysis
Reads `matches.csv` and prints the telemetry report.

---

## Getting Started

1. Clone the repository
   git clone https://github.com/BogdanD3/Minesweeper.git
   cd minesweeper-project

2. Switch to development branch
   git checkout development
   git pull origin development

3. Switch to your assigned branch
   git checkout feature/your-branch-name

4. Write your code, then commit and push
   git add .
   git commit -m "Short description of what you did"
   git push origin feature/your-branch-name

5. Open a Pull Request on GitHub
   - Go to the repository on GitHub
   - Click "Compare & pull request"
   - Set base branch to: development
   - Write a short description and submit

---

## Branch Strategy
- `main` — stable, working code only. No direct pushes.
- `development` — integration branch. All PRs go here first.
- Feature branches — one per task, e.g. `feature/coordinate-queue`, `feature/board-logic`

**Workflow:**
1. Branch off `development`
2. Write your code
3. Open a Pull Request into `development`
4. Bogdan will review and check before merging

---

## Task Division

### Milestone 1 — The Intelligent Board

| Task | Description | Assigned To | Status |
|------|-------------|-------------|--------|
| `CellState` enum | HIDDEN, REVEALED, FLAGGED | Angela | ✅ Done |
| `GameOutcome` enum | IN_PROGRESS, VICTORY, DEFEAT | Angela | ✅ Done |
| `Cell` class | mine, state, adjacentMines | Angela | ✅ Done |
| `CoordinateQueue` | Custom FIFO queue, no java.util | Nevena | ✅ Done |
| `Board` class | Grid, mine placement, BFS reveal | Nevena (fixed by Bogdan) | ✅ Done |

### Milestone 2 — Automated Player & Telemetry

| Task | Description | Assigned To | Status |
|------|-------------|-------------|--------|
| `Move` class | row, col, wasSafe | Bogdan | ✅ Done |
| `NodeMove` class | Linked list node | Bogdan | ✅ Done |
| `MyLinkedList` class | Custom singly linked list | Bogdan | ✅ Done |
| `Player` class | playTurn(), getMoveHistory() | Bogdan | ✅ Done |
| `GamesSimulator` | 1000 matches, CSV output | Bogdan | ✅ Done |

### Milestone 3 — Data Analysis

| Task | Description | Assigned To | Status |
|------|-------------|-------------|--------|
| `MatchSummary` class | CSV row model, Comparable | Angela | ✅ Done |
| `MatchFactory` class | CSV parsing | Angela (fixed by Bogdan) | ✅ Done |
| `MatchDataset` class | SortedSet + Stream queries | Juan | ✅ Done |
| `TestMatchesAnalysis` | Main report entry point | Juan (fixed by Bogdan) | ✅ Done |

---

## Project Structure

```
src/
└── minesweeper/
    ├── model/            → CellState, GameOutcome, Cell
    ├── datastructures/   → CoordinateQueue, Board
    ├── simulation/       → Move, NodeMove, MyLinkedList, Player, GamesSimulator
    └── analysis/         → MatchSummary, MatchDataset, MatchFactory, TestMatchesAnalysis
```

---

## Notes
- No `java.util` in `CoordinateQueue` or `MyLinkedList`
- No recursion in `revealCell()` — must use BFS with `CoordinateQueue`
- Deadline: **May 19th**
