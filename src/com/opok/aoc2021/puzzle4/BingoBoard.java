package com.opok.aoc2021.puzzle4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BingoBoard {

    private final String MARKED_VALUE = "";
    private String[][] values;

    public BingoBoard(String[][] values) {
        this.values = values;
    }

    public static BingoBoard parse(List<String> data) {
        String[][] boardInitData;
        boardInitData = new String[5][];
        for(int i=0 ; i<5 ; i++) {
            boardInitData[i] = Arrays.stream(data.get(i).split(" "))
                    .filter(s -> !s.isEmpty()) // because of the leading space before single digit values in matrices
                    .toArray(String[]::new);
        }
        return new BingoBoard(boardInitData);
    }

    public void markValue(String value) {
        for (int i=0 ; i<5 ; i++) {
            for (int j=0 ; j<5 ; j++) {
                if (value.equals(values[i][j])) {
                    values[i][j] = MARKED_VALUE;
                    return;
                }
            }
        }
    }

    public boolean isWinner() {
        for (int i=0 ; i<5 ; i++) {
            if (Arrays.stream(getRow(i)).allMatch(s -> MARKED_VALUE.equals(s))
            || Arrays.stream(getColumn(i)).allMatch(s -> MARKED_VALUE.equals(s))) {
                return true;
            }
        }
        return false;
    }

    private String[] getColumn(int columnIndex) {
        String[] column = new String[values.length];
        for(int rowIndex=0 ; rowIndex<values.length ; rowIndex++) {
            column[rowIndex] = values[rowIndex][columnIndex];
        }
        return column;
    }

    private String[] getRow(int index) {
        return values[index];
    }

    public int getSumUnmarked() {
        int sum = 0;
        for(String[] row : values) {
            for(String cell : row) {
                try {
                    sum += Integer.parseInt(cell);
                } catch (NumberFormatException ignore) {
                    // marked value (empty string)
                }
            }
        }
        return sum;
    }
}
