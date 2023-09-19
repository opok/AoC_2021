package com.opok.aoc2021;

import com.opok.aoc2021.puzzle8.MixedWiringSegmentDisplaySolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// *******************************
//
//  7 segment display
//
// *******************************
public class Puzzle8b implements PuzzleSolver {


    Integer[] uniqueValueLengths = {2, 3, 4, 7};

    @Override
    public void solve(ArrayList<String> data) {
        int sum = 0;
        for(String d : data) {
            sum = sum + getDecodedOutput(d);
        }

        System.out.println("Sum of decoded output values is " + sum);
    }

    private int getDecodedOutput(String line) {
        String[] input = line.split("\\|", 2)[0].trim().split(" ");
        String[] output = line.split("\\|", 2)[1].trim().split(" ");

        MixedWiringSegmentDisplaySolver mapper;
        mapper = new MixedWiringSegmentDisplaySolver(input);

        return Integer.parseInt(
                Arrays
                .stream(output)
                .map(s -> String.valueOf(mapper.get(s)))
                .collect(Collectors.joining())
        );
    }
}
