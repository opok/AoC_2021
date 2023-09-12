package com.opok.aoc2021;

import com.opok.aoc2021.puzzle5.Line;
import com.opok.aoc2021.puzzle5.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// *********************************
//
//    HOT SPRINGS 1
//
// only horizontal or vertical lines
// *********************************
public class Puzzle5a implements PuzzleSolver {
        
    public void solve(ArrayList<String> data) {
        List<Line> lines = parseLines(data);

        Map<Point, Integer> map = new HashMap<>();
        for (Line l : lines) {
            for (Point p : l.getAllPoints()) {
                map.put(p, map.containsKey(p) ? (map.get(p) + 1) : 1);
            }
        }

        long result = map.values().stream().filter(integer -> integer>=2).count();
        System.out.println("Number of places on map where at least 2 lines cross is " + result);
    }

    List<Line> parseLines(ArrayList<String> data) {
        return data.stream()
                .map(s -> parseLine(s))
                .filter(line -> line.isVertical()||line.isHorizontal()) // filter out diagonal lines
                .toList();
    }

    Line parseLine(String inputStr) {
        String[] coordinatePairs = inputStr.split("->", 2);
        String[] coordinates1 = coordinatePairs[0].split(",",2);
        String[] coordinates2 = coordinatePairs[1].split(",",2);
        Point p1 = new Point(Integer.parseInt(coordinates1[0].trim()), Integer.parseInt(coordinates1[1].trim()));
        Point p2 = new Point(Integer.parseInt(coordinates2[0].trim()), Integer.parseInt(coordinates2[1].trim()));
        return new Line(p1,p2);
    }
}
