package com.opok;

import java.util.ArrayList;

public class Puzzle2b implements PuzzleSolver {
    @Override
    public void solve(ArrayList<String> data) {
        // commands: forward, up, down
        int x=0, aim=0, depth=0;
        for (String s : data) {
            SubmarineControlCommand c = new SubmarineControlCommand(s);

            switch (c.getCommand()) {
                case down -> aim += c.getValue();
                case forward -> {
                    x += c.getValue();
                    depth += c.getValue() * aim;
                }
                case up -> aim -= c.getValue();
            }
        }
        System.out.println("x=" + x + " dep=" + depth + " x*dep=" + x*depth);
    }
}
