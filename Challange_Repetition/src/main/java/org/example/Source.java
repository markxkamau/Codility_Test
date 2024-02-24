package org.example;

import java.util.*;

public class Source {
    public String P;
    public String Q;

    public Source(){}
    public Source(String p, String q) {
        this.P = p;
        this.Q = q;
    }

    private static List<String> generatePossibleStrings(String p, String q) {
        List<String> result = new ArrayList<>();
        generate("", p, q, result);
        return result;
    }

    private static void generate(String current, String p, String q, List<String> result) {
        if (current.length() == p.length()) {
            result.add(current);
            return;
        }

        generate(current + p.charAt(current.length()), p, q, result);
        generate(current + q.charAt(current.length()), p, q, result);
    }

    private static int countDistinctLetters(String str) {
        Set<Character> distinctLetters = new HashSet<>();
        for (char c : str.toCharArray()) {
            distinctLetters.add(c);
        }
        return distinctLetters.size();
    }

    private boolean checkLength() {
        if (P.length() == Q.length() && P.length() < 200000) {
            String regex = "^[a-z]+$";

            if (!P.matches(regex) || !Q.matches(regex)) {
                return false;
            }

            Set<Character> distinctChars = new HashSet<>();
            for (char c : P.toCharArray()) {
                distinctChars.add(c);
            }
            for (char c : Q.toCharArray()) {
                distinctChars.add(c);
            }

            if (distinctChars.size() > 20) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public void iterateString() {
        char[] p = P.toCharArray();
        char[] q = Q.toCharArray();

        StringBuilder combinedString = new StringBuilder();
        combinedString.append(P);
        combinedString.append(Q);
        char[] combinedChars = combinedString.toString().toCharArray();

        int[] repeatedCharCounts = new int[26];
        int max = 0;

        for (char ch : combinedChars) {
            repeatedCharCounts[ch - 'a']++; // Assuming lower case characters only

            if (repeatedCharCounts[ch - 'a'] > 1) {

                System.out.println("Character '" + ch + "' appears " + repeatedCharCounts[ch - 'a'] + " times");
            }
            if (repeatedCharCounts[ch - 'a'] > max) {
                max = repeatedCharCounts[ch - 'a'];
            }

        }


        System.out.println(combinedString.length());
        System.out.println(p);


    }

    public int solution() {
        // Check for equal length
        if (!checkLength()) {
            return -1; // Handle invalid input
        }

        List<String> possibleStrings = generatePossibleStrings(P, Q);
        int minDistinct = Integer.MAX_VALUE;

        for (String str : possibleStrings) {
            int distinctCount = countDistinctLetters(str);
            minDistinct = Math.min(minDistinct, distinctCount);
        }

        return minDistinct;
    }
}
