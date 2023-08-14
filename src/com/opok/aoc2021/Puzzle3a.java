package com.opok.aoc2021;

import java.util.ArrayList;

public class Puzzle3a implements PuzzleSolver {

    @Override
    public void solve(ArrayList<String> data) {
        int[] countOf1 = new int[12];
        for (String s : data) {
            for (int i=0 ; i<12 ; i++) {
                if ("1".equals(Character.toString(s.charAt(i)))) {
                    countOf1[i] = countOf1[i] + 1;
                }
            }
        }

        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int count : countOf1) {
            if (count > data.size()*0.5) { // at this position most frequent are "1"
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
