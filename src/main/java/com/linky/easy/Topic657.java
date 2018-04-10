package com.linky.easy;

import com.linky.stdlib.StdIn;
import com.linky.stdlib.StdOut;

import java.util.LinkedList;
import java.util.List;

/**
 * Judge Route Circle
 * https://leetcode.com/problems/judge-route-circle/description
 */
public class Topic657 {

    public static boolean judgeCircle(String moves) {

        List<Character> listU = new LinkedList<>();
        List<Character> listD = new LinkedList<>();
        List<Character> listR = new LinkedList<>();
        List<Character> listL = new LinkedList<>();

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'R':
                    if (!listL.isEmpty()) {
                        listL.remove(0);
                    } else {
                        listR.add(c);
                    }
                    break;
                case 'L':
                    if (!listR.isEmpty()) {
                        listR.remove(0);
                    } else {
                        listL.add(c);
                    }
                    break;
                case 'U':
                    if (!listD.isEmpty()) {
                        listD.remove(0);
                    } else {
                        listU.add(c);
                    }
                    break;
                case 'D':
                    if (!listU.isEmpty()) {
                        listU.remove(0);
                    } else {
                        listD.add(c);
                    }
                    break;
            }
        }

        return listD.isEmpty() && listU.isEmpty() && listR.isEmpty() && listL.isEmpty();
    }

    public static void main(String[] args) {

        String moves = StdIn.readString();
        StdOut.println(judgeCircle(moves));

    }
}
