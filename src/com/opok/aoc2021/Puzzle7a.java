package com.opok.aoc2021;

import java.util.*;

// ***************************
//
//  CRAB SUBMARINES
//
//  error = distance
// ***************************
public class Puzzle7a implements PuzzleSolver {

    @Override
    public void solve(ArrayList<String> data) {
        // data will be just 1 line
        List<Integer> crabPositions = new ArrayList<>(Arrays
                .stream(data.get(0).split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList());
        int median = crabPositions.stream().sorted().toList().get(crabPositions.size()/2);

        int targetPosition = median;
        long sumErrors = calculateErrors(crabPositions, targetPosition);
        // iteratively search for least sum of errors
        while (true) {
            long sumErrorsLeftSide = calculateErrors(crabPositions, targetPosition-1);
            long sumErrorsRightSide = calculateErrors(crabPositions, targetPosition+1);
            if (sumErrorsLeftSide < sumErrors) {
                targetPosition = targetPosition-1;
                sumErrors = sumErrorsLeftSide;
                System.out.println("New target=" + targetPosition + " sumErrors=" + sumErrors);
                continue;
            }
            if (sumErrorsRightSide < sumErrors) {
                targetPosition = targetPosition+1;
                sumErrors = sumErrorsRightSide;
                System.out.println("New target=" + targetPosition + " sumErrors=" + sumErrors);
                continue;
            }
            break;
        }

        System.out.println("Minimum sum of errors is " + sumErrors + " at position " + targetPosition);
    }

    private long calculateErrors(List<Integer> initialPositions, int target) {
        return initialPositions
                .stream()
                .map(position -> calculateError(target, position))
                .reduce((i1, i2) -> i1 + i2)
                .get();
    }

    int calculateError(int target, int position) {
        return Math.abs(target - position);
    }
}
