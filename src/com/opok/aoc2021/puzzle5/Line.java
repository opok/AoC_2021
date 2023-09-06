package com.opok.aoc2021.puzzle5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final Point point1;
    private final Point point2;

    public Line(Point point1, Point point2) {
        assert point1.x==point2.x || point1.y==point2.y; // only vertical or horizontal

        this.point1 = point1;
        this.point2 = point2;
    }

    public List<Point> getAllPoints() {
        List<Point> points = new ArrayList<>();
        if(point1.x == point2.x) {
            int x = point1.x;
            int[] yValues = IntStream.rangeClosed(Math.min(point1.y, point2.y), Math.max(point1.y, point2.y)).toArray();
            for(int y : yValues) {
                points.add(new Point(x,y));
            }
        } else if (point1.y == point2.y) {
            int y = point1.y;
            int[] xValues = IntStream.rangeClosed(Math.min(point1.x, point2.x), Math.max(point1.x, point2.x)).toArray();
            for(int x : xValues) {
                points.add(new Point(x,y));
            }
        }
        return points;
    }

}
