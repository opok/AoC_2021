package com.opok.aoc2021;

import java.util.ArrayList;

public class Puzzle3a implements PuzzleSolver {

    static final int COLUMN_COUNT = 12;

    @Override
    public void solve(ArrayList<String> data) {
        int[] countsOf1s = new int[COLUMN_COUNT];
        for (String s : data) {
            for (int col=0 ; col<COLUMN_COUNT ; col++) {
                if ("1".equals(Character.toString(s.charAt(col)))) {
                    countsOf1s[col] = countsOf1s[col] + 1;
                }
            }
        }

        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int countOf1InColumn : countsOf1s) {
            if (countOf1InColumn > data.size()*0.5) { // at this position most frequent are "1"
                gamma.append(1);
                epsilon.append(0);
            } else { // most frequent are "0"
                gamma.append(0);
                epsilon.append(1);
            }
        }

        int gammaInt = Integer.parseInt(gamma.toString(), 2);
        int epsilonInt = Integer.parseInt(epsilon.toString(), 2);

        System.out.println("gamma=" + gamma + " eps=" + epsilon + " result=" + gammaInt*epsilonInt);
    }
}
