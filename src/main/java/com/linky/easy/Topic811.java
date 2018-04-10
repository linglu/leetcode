package com.linky.easy;

import com.linky.stdlib.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Subdomain Visit Count
 * https://leetcode.com/problems/subdomain-visit-count/description/
 */
public class Topic811 {

    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            int count = Integer.parseInt(s.split(" ")[0]);
            String subdomain = s.split(" ")[1];

            map.put(subdomain, map.getOrDefault(subdomain, 0) + count);

            String[] domains = subdomain.split("\\.");
            int length = domains.length;

            int start = 1;
            do {
                StringBuilder sb = new StringBuilder();
                for (int i = start; i < length; i++) {
                    sb.append(domains[i]).append(".");
                }

                if (sb.length() > 0)
                    sb.deleteCharAt(sb.length() - 1);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);

                start += 1;
            } while (start < length);
        }

        List<String> ls = new ArrayList<>();
        for (String key : map.keySet()) {
            ls.add(map.get(key) + " " + key);

            StdOut.println(map.get(key) + " " + key);
        }

        return ls;
    }

    public static void main(String[] args) {

        new Topic811().subdomainVisits(args);

    }
}
