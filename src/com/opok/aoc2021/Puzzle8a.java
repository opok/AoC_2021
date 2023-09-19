package com.opok.aoc2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// *******************************
//
//  7 segment display
//
// *******************************
public class Puzzle8a implements PuzzleSolver {


    Integer[] uniqueValueLengths = {2, 3, 4, 7};

    @Override
    public void solve(ArrayList<String> data) {

        List<String> outputValues = parseOutputValues(data);
        int count = 0;
        for (String outVal : outputValues) {
            if(Arrays.asList(uniqueValueLengths).contains(outVal.length())) {
                count = count+1;
            }
        }

        System.out.println("Count of unique values in output values " + count);
    }

    private List<String> parseOutputValues(ArrayList<String> data) {
        return List.of(
                data.stream()
                        .map(s -> s.split("\\|", 2)[1].trim())
                        .collect(Collectors.joining(" "))
                        .split(" ")
        );
    }
}
