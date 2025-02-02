package com.company.TopInterview150.ArrayString;

import java.util.*;

public class InsertDeleteGetRandom {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    int size = 0;

    public InsertDeleteGetRandom() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, size);
        list.add(size, val);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int lastElement = list.get(size-1);
            list.set(index, lastElement);
            list.remove(size-1);
            map.put(lastElement, index);
            map.remove(val);
            size--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        Random rand = new Random();
        int value = rand.nextInt(size);
        return list.get(value);
    }
}
