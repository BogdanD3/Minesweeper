# Minesweeper Project
Collaborative project between University of Montenegro (PMF) and University of Seville.

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
| `CellState` enum | HIDDEN, REVEALED, FLAGGED | TBD | Not started |
| `GameOutcome` enum | IN_PROGRESS, VICTORY, DEFEAT | TBD | Not started |
| `Cell` class | mine, state, adjacentMines | TBD | Not started |
| `CoordinateQueue` | Custom FIFO queue, no java.util | TBD | Not started |
| `Board` class | Grid, mine placement, BFS reveal | TBD | Not started |

### Milestone 2 — Automated Player & Telemetry

| Task | Description | Assigned To | Status |
|------|-------------|-------------|--------|
| `Move` class | row, col, wasSafe | TBD | Not started |
| `NodeMove` class | Linked list node | TBD | Not started |
| `MyLinkedList` class | Custom singly linked list | TBD | Not started |
| `Player` class | playTurn(), getMoveHistory() | TBD | Not started |
| `GamesSimulator` | 1000 matches, CSV output | TBD | Not started |

### Milestone 3 — Data Analysis

| Task | Description | Assigned To | Status |
|------|-------------|-------------|--------|
| `MatchSummary` class | CSV row model, Comparable | TBD | Not started |
| `MatchDataset` class | SortedSet + Stream queries | TBD | Not started |
| `MatchFactory` class | CSV parsing | TBD | Not started |
| `TestMatchesAnalysis` | Main report entry point | TBD | Not started |

---

## Project Structure

```
src/
└── minesweeper/
    ├── model/            → CellState, GameOutcome, Cell, Board
    ├── datastructures/   → CoordinateQueue
    ├── simulation/       → Move, NodeMove, MyLinkedList, Player, GamesSimulator
    └── analysis/         → MatchSummary, MatchDataset, MatchFactory, TestMatchesAnalysis
```

---

## Notes
- No `java.util` in `CoordinateQueue` or `MyLinkedList`
- No recursion in `revealCell()` — must use BFS with `CoordinateQueue`
- Deadline: **May 19th**
