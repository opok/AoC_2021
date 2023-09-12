package com.opok.aoc2021.puzzle5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {
    final Point point1;
    final Point point2;

    public Line(Point point1, Point point2) {
        checkArguments(point1, point2);

        this.point1 = point1;
        this.point2 = point2;
    }

    void checkArguments(Point point1, Point point2) {
        assert point1.x == point2.x || point1.y == point2.y; // only vertical or horizontal
    }

    public List<Point> getAllPoints() {
        List<Point> points = new ArrayList<>();

        Integer[] Xes = isVertical() ?
                createFilledArray(point1.x, calcPointsCount())
                : createSequence(point1.x, point2.x);
        Integer[] Ys = isHorizontal() ?
                createFilledArray(point1.y, calcPointsCount())
                : createSequence(point1.y, point2.y);

        for(int i=0 ; i<calcPointsCount() ; i++) {
            points.add(new Point(Xes[i], Ys[i]));
        }

        return points;
    }

    public boolean isHorizontal() {
        return point1.y == point2.y;
    }

    public boolean isVertical() {
        return point1.x == point2.x;
    }

    private Integer[] createFilledArray(int value, int size) {
        Integer[] arr = new Integer[size];
        Arrays.fill(arr, value);
        return arr;
    }

    private int calcPointsCount() {
        return Math.max(
                Math.abs(point2.x - point1.x)+1,
                Math.abs(point2.y - point1.y)+1
        );
    }

    private Integer[] createSequence(int num1, int num2) {
        List<Integer> seq = new ArrayList<>();
        int increment = Integer.signum(num2-num1);
        for(int i=num1 ; i != num2+increment ; i = i + increment) {
            seq.add(i);
        }
        return seq.toArray(new Integer[seq.size()]);
    }
}
