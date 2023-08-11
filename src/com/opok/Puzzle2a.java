package com.opok;

import java.util.ArrayList;

public class Puzzle2a implements PuzzleSolver {
    @Override
    public void solve(ArrayList<String> data) {
        // commands: forward, up, down
        int x=0, dep=0;
        for (String s : data) {
            SubmarineControlCommand c = new SubmarineControlCommand(s);

            switch (c.getCommand()) {
                case down -> dep += c.getValue();
                case forward -> x += c.getValue();
                case up -> dep -= c.getValue();
            }
        }
        System.out.println("x=" + x + " dep=" + dep + " x*dep=" + x*dep);
    }
}
