package com.linky.easy;

import com.linky.stdlib.StdIn;
import com.linky.stdlib.StdOut;

/**
 * Hamming Distance
 * https://leetcode.com/problems/hamming-distance/description/
 */
public class Topic461 {

    public static int hammingDistance(int x, int y) {

        int result = x ^ y;
        String bs = Integer.toBinaryString(result);
        int cnt = 0;
        for (int i = 0; i < bs.length(); i++) {
            if (bs.charAt(i) == '1') {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        int x = StdIn.readInt();
        int y = StdIn.readInt();

        StdOut.println(hammingDistance(x, y));
    }
}
