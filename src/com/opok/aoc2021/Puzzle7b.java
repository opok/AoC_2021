package com.opok.aoc2021;

// *******************************
//
//  CRAB SUBMARINES 2
//
// more complicated error function
// *******************************
public class Puzzle7b extends Puzzle7a implements PuzzleSolver {

    int calculateError(int target, int position) {
        int distance =  Math.abs(target - position);
        int error = 0;
        for(int i = distance ; i > 0 ; i--) {
            error+=i;
        }
        return error;
    }
}
