package com.linky.easy;

import com.linky.stdlib.StdIn;
import com.linky.stdlib.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unique Morse Code Words
 * https://leetcode.com/problems/unique-morse-code-words/description/
 */
public class Topic804 {

    private static String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public static int uniqueMorseRepresentations(String[] words) {

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                sb.append(MORSE[word.charAt(j) - 97]);
            }
            hm.put(sb.toString(), 1);
        }
        return hm.size();
    }

    public static void main(String[] args) {

        List<String> input = new ArrayList<>();

        String in = StdIn.readString();
        while (!in.equals("0")) {
            input.add(in);
            in = StdIn.readString();
        }

        String[] words = new String[input.size()];
        input.toArray(words);
        StdOut.println(uniqueMorseRepresentations(words));

    }
}
