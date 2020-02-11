package org.forrestlin;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: main
 * @author: forrestlin
 * @create: 2020-02-11 22:39
 */
public class Main {

    public static void main(String[] args) {
        List<String> tl = new ArrayList<>();
        tl.add("A");
        tl.add("A");
        tl.add("B");
        System.out.println(tl);
        tl.remove("A");
        System.out.println(tl);
    }
}
