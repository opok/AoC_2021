package com.opok.aoc2021;

import com.opok.aoc2021.puzzle4.BingoBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Puzzle4b extends Puzzle4a {
        
    public void solve(ArrayList<String> data) {
        // 1st line are the drawn numbers
        String[] drawnNumbers = data.get(0).split(",");

        // then empty line separated 5x5 matrices
        parseMatrices(new ArrayList<String>(data.subList(2, data.size())));

        int recentWinningScore = 0;
        for (String drawnNumber : drawnNumbers) {
            markDrawnNumber(drawnNumber);
            
            // remove winning boards
            int temp = recentWinningBoardScore(drawnNumber);
            if(temp > 0) {
                recentWinningScore = temp;
            }
        }

        System.out.println("Last winning board got score " + recentWinningScore);
    }

    private int recentWinningBoardScore(String recentDrawnNumber) {
        List<BingoBoard> recentWinningBoards = boards.stream().filter(bingoBoard -> bingoBoard.isWinner()).collect(Collectors.toList());
        boards = new ArrayList<>(boards.stream().filter(bingoBoard -> !bingoBoard.isWinner()).collect(Collectors.toList()));

        if (recentWinningBoards.size()>0) {
            BingoBoard recentWinningBoard = recentWinningBoards.get(0);
            return Integer.parseInt(recentDrawnNumber) * recentWinningBoard.getSumUnmarked();
        }

        return 0;
    }
}
