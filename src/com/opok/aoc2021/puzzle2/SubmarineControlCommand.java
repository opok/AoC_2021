package com.opok.aoc2021.puzzle2;

public class SubmarineControlCommand {
    private final COMMAND c;
    private final int value;

    public enum COMMAND {
        down, forward, up
    }

    public int getValue() {
        return value;
    }

    public COMMAND getCommand() {
        return c;
    }
    public SubmarineControlCommand(String s) {
        String[] parts = s.split(" ");
        c = COMMAND.valueOf(parts[0]);
        value = Integer.parseInt(parts[1]);
    }
}
