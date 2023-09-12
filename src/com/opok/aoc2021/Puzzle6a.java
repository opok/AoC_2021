package com.opok.aoc2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// **********************
//
//  LANTERNFISH BREEDING
//
//  after 8 days
// *********************
public class Puzzle6a implements PuzzleSolver {

    static final int NUM_DAYS = 80;
    @Override
    public void solve(ArrayList<String> data) {
        // data will be just 1 line
        List<Integer> prevGeneration = new ArrayList<>(Arrays
                .stream(data.get(0).split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList());

        List<Integer> currentGeneration = null;
        for(int day = 1 ; day <= NUM_DAYS ; day++) {
            currentGeneration = breed(prevGeneration);
            prevGeneration = currentGeneration;
            System.out.println("Generation " + day + " has " + currentGeneration.size() + " fishes.");
        }

        System.out.println("After " + NUM_DAYS + " days there are " + currentGeneration.size() + " fishes.");
    }

    private List<Integer> breed(List<Integer> generation) {
        List<Integer> nextGen = new ArrayList<>();
        for(Integer x : generation) {
            if (x==0) {
                nextGen.add(6);
                nextGen.add(8);
            } else {
                nextGen.add(x-1);
            }
        }
        return nextGen;
    }
}
