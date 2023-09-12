package com.opok.aoc2021;

import java.util.*;

// ***************************
//
//  LANTERNFISH BREEDING
//
//  after 256 days... TOO MANY
// ***************************
public class Puzzle6b implements PuzzleSolver {

    static final int NUM_DAYS = 256;
    static final int MAX_GROUP_NUM = 8;
    @Override
    public void solve(ArrayList<String> data) {
        // data will be just 1 line
        List<Integer> firstGeneration = new ArrayList<>(Arrays
                .stream(data.get(0).split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList());

        Map<Integer, Long> groups = new HashMap<>();
        for(int g=0 ; g<=MAX_GROUP_NUM ; g++) {
            int finalG = g;
            groups.put(g, firstGeneration.stream().filter(i -> i== finalG).count());
        }

        // do 256 times
        for(int day=1 ; day <=NUM_DAYS ; day++) {
            groups = breed(groups);
            System.out.println("Day: " + day + " fishes: " + groups.values().stream().reduce((i1, i2) -> i1+i2).get());
        }

        System.out.println("After " + NUM_DAYS + " days there are " + groups.values().stream().reduce((i1, i2) -> i1+i2).get() + " fishes.");
    }

    private Map<Integer, Long> breed(Map<Integer, Long> groups) {
        Map<Integer, Long> newGroups = new HashMap<>();

        newGroups.put(8, groups.get(0));
        newGroups.put(7, groups.get(8));
        newGroups.put(6, groups.get(7)+groups.get(0));
        newGroups.put(5, groups.get(6));
        newGroups.put(4, groups.get(5));
        newGroups.put(3, groups.get(4));
        newGroups.put(2, groups.get(3));
        newGroups.put(1, groups.get(2));
        newGroups.put(0, groups.get(1));

        return newGroups;
    }
}
