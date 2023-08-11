package com.opok;

import java.util.ArrayList;
import java.util.Arrays;

public class Puzzle1b implements PuzzleSolver {
    @Override
    public void solve(ArrayList<String> data) {
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
}
