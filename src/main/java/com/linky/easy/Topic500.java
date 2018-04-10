package com.linky.easy;

import com.linky.stdlib.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * Keyboard Row
 * https://leetcode.com/problems/keyboard-row/description/
 */
public class Topic500 {

    public String[] findWords(String[] words) {

        List<String> ls = new ArrayList<>();
        for (String word : words) {

            String wordLowerCase = word.toLowerCase();
            int groupId = getGroupId(wordLowerCase.charAt(0));
            int index;
            for (index = 1; index < wordLowerCase.length(); index++) {
                char c = wordLowerCase.charAt(index);
                if (!isInGroup(c, groupId)) {
                    break;
                }
            }

            if (index == wordLowerCase.length()) {
                ls.add(word);
            }
        }

        String[] ss = new String[ls.size()];
        ls.toArray(ss);
        return ss;
    }

    private int getGroupId(char c) {
        switch (c) {
            case 'q':
            case 'w':
            case 'e':
            case 'r':
            case 't':
            case 'y':
            case 'u':
            case 'i':
            case 'o':
            case 'p':
                return 1;
            case 'a':
            case 's':
            case 'd':
            case 'f':
            case 'g':
            case 'h':
            case 'j':
            case 'k':
            case 'l':
                return 2;
            case 'z':
            case 'x':
            case 'c':
            case 'v':
            case 'b':
            case 'n':
            case 'm':
                return 3;
            default:
                return -1;

        }
    }

    private boolean isInGroup(char c, int groupId) {

        switch (c) {
            case 'q':
            case 'w':
            case 'e':
            case 'r':
            case 't':
            case 'y':
            case 'u':
            case 'i':
            case 'o':
            case 'p':
                return groupId == 1;
            case 'a':
            case 's':
            case 'd':
            case 'f':
            case 'g':
            case 'h':
            case 'j':
            case 'k':
            case 'l':
                return groupId == 2;
            case 'z':
            case 'x':
            case 'c':
            case 'v':
            case 'b':
            case 'n':
            case 'm':
                return groupId == 3;

        }

        return false;
    }

    public static void main(String[] args) {

        String[] ss = new Topic500().findWords(args);

        for (String s : ss) {
            StdOut.print(s + "  ");
        }
    }
}
