package com.opok.aoc2021;

import java.util.ArrayList;

public class Puzzle1a implements PuzzleSolver {

    @Override
    public void solve(ArrayList<String> data) {
        int count = 0;
        for (int i=0 ; i+1 < data.size() ; i++) {
            if(Integer.parseInt(data.get(i)) < Integer.parseInt(data.get(i+1))) {
                count++;
            }
        }
        System.out.println("Count of increasing deltas: " + count);
    }
}
