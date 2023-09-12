package com.opok.aoc2021;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Puzzle3b implements PuzzleSolver {
    @Override
    public void solve(ArrayList<String> data) {

        ArrayList<String> dataForOxygen = (ArrayList<String>) data.clone();
        ArrayList<String> dataForCO2 = (ArrayList<String>) data.clone();

        filterMostFrequent(dataForOxygen, "1");
        assert dataForOxygen.size() == 1;
        String oxyResult = dataForOxygen.get(0);

        filterLeastFrequent(dataForCO2, "0");
        assert dataForCO2.size() == 1;
        String co2Result = dataForCO2.get(0);

        int oxyDec = Integer.parseInt(oxyResult, 2);
        int co2Dec = Integer.parseInt(co2Result, 2);
        System.out.println("oxygen=" + oxyDec + " CO2=" + co2Dec + " answer=" + oxyDec*co2Dec);
    }

    private List<String> filterLeastFrequent(ArrayList<String> data, String prefer) {
        for(int pos=0 ; pos<12 && data.size()>1 ; pos++) {
            String keepValue = computeLeastFrequentAtPosition(data, pos, prefer);
            int finalPos = pos;
            data.removeIf(s -> !keepValue.equals(s.substring(finalPos, finalPos + 1)));
        }
        return data;
    }

    private List<String> filterMostFrequent(ArrayList<String> data, String prefer) {
        for(int pos=0 ; pos<12 && data.size()>1 ; pos++) {
            String keepValue = computeMostFrequentAtPosition(data, pos, prefer);
            int finalPos = pos;
            data.removeIf(s -> !keepValue.equals(s.substring(finalPos, finalPos + 1)));
        }
        return data;
    }

    /**
     *
     * @param data
     * @param column
     * @param prefer in case of equal count of "0" and "1" which to return
     * @return
     */
    private String computeMostFrequentAtPosition(ArrayList<String> data, int column, String prefer) {
        int countOf1 = count1sInColumn(data, column);
        if (countOf1 == data.size()*0.5) {
            return prefer;
        }
        return (countOf1 > data.size()*0.5) ? "1" : "0";
    }

    private String computeLeastFrequentAtPosition(ArrayList<String> data, int position, String prefer) {
        int countOf1 = count1sInColumn(data, position);
        if (countOf1 == data.size()*0.5) {
            return prefer;
        }
        return (countOf1 > data.size()*0.5) ? "0" : "1";
    }

    private static int count1sInColumn(ArrayList<String> data, int column) {
        int countOf1 = 0;
        for (String s : data) {
            if ("1".equals(Character.toString(s.charAt(column)))) {
                countOf1 = countOf1 + 1;
            }
        }
        return countOf1;
    }
}
