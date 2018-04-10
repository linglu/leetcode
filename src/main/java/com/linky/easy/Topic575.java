package com.linky.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Distribute Candies
 * https://leetcode.com/problems/distribute-candies/description/
 */
public class Topic575 {

    public int distributeCandies(int[] candies) {

        int length = candies.length;
        Set<Integer> si = new HashSet<>();

        for (int candy : candies) {
            si.add(candy);
        }

        Math.min(si.size(), length /2);
        return si.size() >= length / 2 ? si.size() : si.size();

    }
}
