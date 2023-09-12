package com.opok.aoc2021;

import com.opok.aoc2021.puzzle5.Line;

import java.util.ArrayList;
import java.util.List;

// ***********************
//
//    HOT SPRINGS 2
//
// with diagonal lines
// ***********************

public class Puzzle5b extends Puzzle5a implements PuzzleSolver {

    List<Line> parseLines(ArrayList<String> data) {
        return data.stream().map(s -> parseLine(s)).toList();
    }
}
