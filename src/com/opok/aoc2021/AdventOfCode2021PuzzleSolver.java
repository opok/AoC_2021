package com.opok.aoc2021;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AdventOfCode2021PuzzleSolver {
    private static String inputFileName;
    private static String puzzleId;

    public static void main(String[] args) throws IOException {
        parseArguments(args);
        ArrayList<String> data = loadData();
        PuzzleSolver solver = createPuzzleSolver(puzzleId);
        solver.solve(data);
    }

    private static PuzzleSolver createPuzzleSolver(String task) {
        switch (task) {
            case "1a" -> {
                return new Puzzle1a();
            }
            case "1b" -> {
                return new Puzzle1b();
            }
            case "2a" -> {
                return new Puzzle2a();
            }
            case "2b" -> {
                return new Puzzle2b();
            }
            case "3a" -> {
                return new Puzzle3a();
            }
            case "3b" -> {
                return new Puzzle3b();
            }
            case "4a" -> {
                return new Puzzle4a();
            }
            case "4b" -> {
                return new Puzzle4b();
            }
            case "5a" -> {
                return new Puzzle5a();
            }
            default -> throw new UnsupportedOperationException();
        }
    }

    private static ArrayList<String> loadData() throws IOException {
        BufferedReader reader = null;
        ArrayList<String> data = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(inputFileName));
        } catch (FileNotFoundException e) {
            System.exit(1);
        }

        String line;
        while ((line = reader.readLine()) != null) {
            data.add(line);
        }
        return data;
    }

    private static void parseArguments(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Usage: puzzleNumber inputFile");
        }

        puzzleId = args[0];
        inputFileName = args[1];
    }

}