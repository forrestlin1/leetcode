package org.forrestlin;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: leetcode
 * @description: main
 * @author: forrestlin
 * @create: 2020-02-11 22:39
 */
public class Main {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("A", "A");
        if (true) {
            System.out.println(1);
            return;
        }

        try {

        } finally {
            System.out.println(2);
        }
    }
}
