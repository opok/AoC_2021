package com.opok.aoc2021;

import com.opok.aoc2021.puzzle4.BingoBoard;

import java.util.ArrayList;
import java.util.List;

// **************************
//
//   BINGO GAME
//
// find board that wins first
// **************************
public class Puzzle4a implements PuzzleSolver {

    ArrayList<BingoBoard> boards = new ArrayList<>();

    @Override
    public void solve(ArrayList<String> data) {
        // 1st line are the drawn numbers
        String[] drawnNumbers = data.get(0).split(",");

        // then empty line separated 5x5 matrices
        parseMatrices(new ArrayList<String>(data.subList(2, data.size())));

        BingoBoard winningBoard;
        for (String drawnNumber : drawnNumbers) {
            markDrawnNumber(drawnNumber);
            if ((winningBoard = getWinningBoard()) != null) {
                int unmarkedSum = winningBoard.getSumUnmarked();
                int score = Integer.parseInt(drawnNumber) * unmarkedSum;
                System.out.println("After drawn number " + drawnNumber
                        + " winning board has sum " + unmarkedSum
                        + " and score " + score);
                return;
            }
        }
    }

    void markDrawnNumber(String drawnNumber) {
        for (BingoBoard b : boards) {
            b.markValue(drawnNumber);
        }
    }

    BingoBoard getWinningBoard() {
        for (BingoBoard b : boards) {
            if (b.isWinner()) {
                return b;
            }
        }
        return null;
    }

    void parseMatrices(ArrayList<String> data) {
        while(data.size() >= 5) {
            boards.add(BingoBoard.parse(data.subList(0, 5)));
            data.subList(0, 5).clear();
            if(data.size() > 0) data.remove(0); // empty line between matrices
        }
    }
}
