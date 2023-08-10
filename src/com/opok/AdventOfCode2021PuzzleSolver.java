package com.opok;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AdventOfCode2021PuzzleSolver {
    private static String inputFileName;
    private static String task;

    public static void main(String[] args) throws IOException {
        parseArguments(args);

        ArrayList<String> data = loadData();

        switch (task) {
            case "1a" -> doTask1a(data);
            case "1b" -> doTask1b(data);
            case "2a" -> doTask2a(data);
            case "2b" -> doTask2b(data);
        }
    }

    private static void doTask2a(ArrayList<String> data) {
        // commands: forward, up, down
        int x=0, dep=0;
        for (String s : data) {
            SubmarineControlCommand c = new SubmarineControlCommand(s);

            switch (c.getCommand()) {
                case down -> dep += c.getValue();
                case forward -> x += c.getValue();
                case up -> dep -= c.getValue();
            }
        }
        System.out.println("x=" + x + " dep=" + dep + " x*dep=" + x*dep);
    }

    private static void doTask2b(ArrayList<String> data) {
        // commands: forward, up, down
        int x=0, aim=0, depth=0;
        for (String s : data) {
            SubmarineControlCommand c = new SubmarineControlCommand(s);

            switch (c.getCommand()) {
                case down -> aim += c.getValue();
                case forward -> {
                    x += c.getValue();
                    depth += c.getValue() * aim;
                }
                case up -> aim -= c.getValue();
            }
        }
        System.out.println("x=" + x + " dep=" + depth + " x*dep=" + x*depth);
    }

    private static void doTask1a(ArrayList<String> data) {
        int count = 0;
        for (int i=0 ; i+1 < data.size() ; i++) {
            if(Integer.parseInt(data.get(i)) < Integer.parseInt(data.get(i+1))) {
                count++;
            }
        }
        System.out.println("Count of increasing deltas: " + count);
    }

    private static void doTask1b(ArrayList<String> data) {
        int count = 0;
        for (int i=0 ; i+3 < data.size() ; i++) {
            int x1 = Arrays.stream(data.stream().mapToInt(Integer::parseInt).toArray(), i, i+3).sum();
            int x2 = Arrays.stream(data.stream().mapToInt(Integer::parseInt).toArray(), i+1, i+4).sum();
            if(x1 < x2) {
                count++;
            }
        }
        System.out.println("Count of increasing deltas of triples: " + count);
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
            throw new IllegalArgumentException("Usage: taskNo inputFile");
        }

        task = args[0];
        inputFileName = args[1];
    }

}