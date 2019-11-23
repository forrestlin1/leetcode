package org.forrestlin.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/*
 * 把数组排成最小的数
 * */
public class L32PrintMinNumber {

    public static void main(String[] args) {
        L32PrintMinNumber test = new L32PrintMinNumber();
        System.out.println(test.PrintMinNumber(new int[]{3,5,1,4,2}));
    }

    public String PrintMinNumber(int[] numbers) {

        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i : numbers) {
            arrayList.add(i + "");
        }

        Collections.sort(arrayList, (a, b) -> {

            int i = 0;
            while (i < a.length() || i < b.length()) {
                char numA = a.charAt(a.length() - 1);
                if (i < a.length()) {
                    numA = a.charAt(i);
                }
                char numB = b.charAt(b.length() - 1);
                if (i < b.length()) {
                    numB = b.charAt(i);
                }
                if (numA == numB) {
                    i++;
                } else {
                    return numA > numB ? 1 : -1;

                }

            }
            return 1;

        });

        String res = arrayList.stream().collect(Collectors.joining());
        return res;
    }
}
