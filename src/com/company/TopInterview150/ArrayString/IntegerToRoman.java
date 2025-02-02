package com.company.TopInterview150.ArrayString;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        int[] array = new int[13];
        array[0] = 1;
        array[1] = 4;
        array[2] = 5;
        array[3] = 9;
        array[4] = 10;
        array[5] = 40;
        array[6] = 50;
        array[7] = 90;
        array[8] = 100;
        array[9] = 400;
        array[10] = 500;
        array[11] = 900;
        array[12] = 1000;

        StringBuilder res = new StringBuilder();
        int index = 12;
        while (num > 0) {
            int quot = num / array[index];
            for (int i = 0; i<quot; i++) {
                res.append(map.get(array[index]));
            }
            num %= array[index];
            index--;
        }
        return res.toString();
    }
}

/*
3749 divide by 1000 = 3 so MMM
reminder = 749 -> divided by 999 X 500 = 1 so D
reminder = 249 -> divided by 400 X 100 = 2 so CC
reminder = 49 -> divided by 50X 40 = 1 so XL
reminder = 9 -> divided by 10X 9 = 1 so IX
reminder = 0 STOP
*/
