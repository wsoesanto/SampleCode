package com.elfin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class Stripe {

    public static String compressPartOne(String string) {
        return Arrays.stream(string.split("/")).map(major -> Arrays.stream(major.split("\\.")).map(minor -> {
            char firstLetter = minor.charAt(0);
            char lastLetter = minor.charAt(minor.length() - 1);
            return String.format(Locale.US, "%c%d%c", firstLetter, minor.length() - 2, lastLetter);
        }).collect(Collectors.joining("."))).collect(Collectors.joining("/"));
    }


    public static String compressPartTwo(String string, int m) {

        return Arrays.stream(string.split("/")).map(major -> {
            String[] minors = major.split("\\.");

            // Do the first m - 1 part like the part one.
            ArrayList<String> toBeJoined = new ArrayList<>();
            // TODO: Check whether it should be m or m - 1.
            int numberOfMinorsToBeDealtWithLikePartOne = Math.min(minors.length, m - 1);
            for (int idx = 0; idx < numberOfMinorsToBeDealtWithLikePartOne; ++idx) {
                String minor = minors[idx];

                char firstLetter = minor.charAt(0);
                char lastLetter = minor.charAt(minor.length() - 1);
                toBeJoined.add(String.format(Locale.US, "%c%d%c", firstLetter, minor.length() - 2, lastLetter));
            }

            // Do the second part
            if (numberOfMinorsToBeDealtWithLikePartOne < minors.length) {
                int totalLength = 0;
                for (int idx = numberOfMinorsToBeDealtWithLikePartOne; idx < minors.length; ++idx) {
                    totalLength += minors[idx].length();
                }
                String firstString = minors[numberOfMinorsToBeDealtWithLikePartOne];
                String lastString = minors[minors.length - 1];
                toBeJoined.add(String.format(Locale.US, "%c%d%c", firstString.charAt(0), totalLength - 2, lastString.charAt(lastString.length() - 1)));
            }
            return String.join(".", toBeJoined);
        }).collect(Collectors.joining("/"));
    }
}
