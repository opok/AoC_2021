package com.opok.aoc2021;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
        try {
            return (PuzzleSolver) Class
                    .forName("com.opok.aoc2021.Puzzle" + task)
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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