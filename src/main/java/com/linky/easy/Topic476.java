package com.linky.easy;

import com.linky.stdlib.StdOut;

/**
 * Number Complement
 * https://leetcode.com/problems/number-complement/description/
 */
public class Topic476 {

    public int findComplement(int num) {

//        String bs = Integer.toBinaryString(num);
//        int sum = 0;
//        for (int i = 0; i < bs.length(); i++) {
//            int c = bs.charAt(i);
//            if (c == '0') {
//                sum += Math.pow(2, bs.length() - i - 1);
//            }
//        }
//        return sum;

        int bits = 0;
        int dnum = num;

        while ( dnum != 0) {
            dnum = dnum >> 1;
            bits++;
        }

        StdOut.println("~0 << bits : " + (~0 << bits));

        int mask = ~(~0 << bits);

        StdOut.println("not 0 : " + ~0);
        StdOut.println("bits : " + bits);
        StdOut.println("mask : " + mask);

        //System.out.println("Num :" + Integer.toString(num,2));
        //System.out.println("Num :" + Integer.toString((mask ^ num),2));
        return (num ^ mask);

    }

    public static void main(String[] args) {
        StdOut.println(new Topic476().findComplement(Integer.parseInt(args[0])));
    }
}
