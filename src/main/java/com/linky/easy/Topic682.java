package com.linky.easy;

import com.linky.stdlib.StdOut;

import java.util.LinkedList;

/**
 * Baseball Game
 * https://leetcode.com/problems/baseball-game/description/
 */
public class Topic682 {

    public int calPoints(String[] ops) {

        LinkedList<Integer> ll = new LinkedList<>();

        for (String opt : ops) {

            switch (opt.charAt(0)) {
                case 'C':
                    ll.pop();
                    break;
                case 'D':
                    ll.push(ll.peek() * 2);
                    break;
                case '+':
                    int top = ll.poll();
                    int sTop = ll.peek();
                    ll.push(top);
                    ll.push(top + sTop);
                    break;
                default:
                    ll.push(Integer.parseInt(opt));
                    break;

            }
        }

        int sum = 0;
        for (Integer aLl : ll) {
            sum += aLl;
        }

        return sum;
    }

    public static void main(String[] args) {
        StdOut.println(new Topic682().calPoints(args));
    }
}
