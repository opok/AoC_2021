package com.opok.aoc2021;

import java.util.ArrayList;

public class Puzzle3b implements PuzzleSolver {
    @Override
    public void solve(ArrayList<String> data) {
        // data.filter by value at X position, boolean most frequent,
        // and use it repeatedly
        ArrayList<String> dataForOxygen = (ArrayList<String>) data.clone();
        ArrayList<String> dataForCO2 = (ArrayList<String>) data.clone();

        filter(dataForOxygen, "1", false);
        assert dataForOxygen.size() == 1;
        String oxyResult = dataForOxygen.get(0);

        filter(dataForCO2, "0", true);
        assert dataForCO2.size() == 1;
        String co2Result = dataForCO2.get(0);

        int oxyDec = Integer.parseInt(oxyResult, 2);
        int co2Dec = Integer.parseInt(co2Result, 2);
        System.out.println("oxygen=" + oxyDec + " CO2=" + co2Dec + " answer=" + oxyDec*co2Dec);
    }

    private ArrayList<String> filter(ArrayList<String> data, String prefer, boolean seekLeastFrequent) {
        for(int pos=0 ; pos<12 && data.size()>1 ; pos++) {
            String keepValue = computeMostFrequentAtPosition(data, pos, prefer, seekLeastFrequent);
            int finalPos = pos;
            data.removeIf(s -> !keepValue.equals(s.substring(finalPos, finalPos + 1)));
        }
        return data;
    }

    private String computeMostFrequentAtPosition(ArrayList<String> data, int position, String prefer, boolean returnLeastFrequent) {
        int countOf1 = 0;
        for (String s : data) {
            if ("1".equals(Character.toString(s.charAt(position)))) {
                countOf1 = countOf1 + 1;
            }
        }
        if (countOf1 == data.size()*0.5) {
            return prefer;
        }
        if (!returnLeastFrequent)
            return (countOf1 > data.size()*0.5) ? "1" : "0";
        else
            return (countOf1 > data.size()*0.5) ? "0" : "1";
    }
}
