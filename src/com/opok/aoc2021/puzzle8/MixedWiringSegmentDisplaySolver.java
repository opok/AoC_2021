package com.opok.aoc2021.puzzle8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MixedWiringSegmentDisplaySolver {

    Map<String, Integer> map = new HashMap<>();
    Map<Integer, String> reverseMap = new HashMap<>();

    public MixedWiringSegmentDisplaySolver(String[] input) {
        String[] inputSorted = getInputSorted(input);

        updateMapWithKnownUniqueValues(inputSorted);
        updateMapWith5CharacterValues(Arrays.stream(inputSorted).filter(s -> s.length()==5).toArray(String[]::new));
        updateMapWith6CharacterValues(Arrays.stream(inputSorted).filter(s -> s.length()==6).toArray(String[]::new));
    }

    private void updateMapWithKnownUniqueValues(String[] input) {
        for (String s : input) {
            if(s.length() == 2) {
                put(s, 1);
            } else if(s.length() == 3) {
                put(s, 7);
            } else if(s.length() == 4) {
                put(s, 4);
            } else if(s.length() == 7) {
                put(s, 8);
            }
        }
    }

    private void put(String s, int i) {
        map.put(s, i);
        reverseMap.put(i, s);
    }

    public int get(String s) {
        s = sort(s);
        return map.get(s);
    }

    private String get(int i) {
        return reverseMap.get(i);
    }

    private void updateMapWith5CharacterValues(String[] input) {
        // 5 segment values are: 2, 3, 5
        // "2" intersection with "4" (known) is only 2 segments
        // "3" intersect" "1" is 2 segments
        for (String value : input) {
            if(intersect(value, get(4)) == 2) {
                put(value, 2);
            } else if (intersect(value, get(1)) == 2) {
                put(value, 3);
            } else {
                put(value, 5);
            }
        }
    }

    private void updateMapWith6CharacterValues(String[] input) {
        // 6 segment values are: 6, 9, 0
        // "6" intersect "1" is only 1 segment
        // "9" intersect "4" is 4 segments
        for (String value : input) {
            if(intersect(value, get(1)) == 1) {
                put(value, 6);
            } else if (intersect(value, get(4)) == 4) {
                put(value, 9);
            } else {
                put(value, 0);
            }
        }
    }


    private int intersect(String s1, String s2) {
        String concat = s1+s2;
        return Arrays
                .stream(concat
                        .chars()
                        .distinct()
                        .mapToObj(i -> (char)i)
                        .toArray(Character[]::new))
                .filter(character -> s1.contains(character.toString()) && s2.contains(character.toString()))
                .toArray()
                .length;
    }

    private static String[] getInputSorted(String[] input) {
        return Arrays
                .stream(input)
                .map(s -> sort(s))
                .toArray(String[]::new);
    }

    private static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
