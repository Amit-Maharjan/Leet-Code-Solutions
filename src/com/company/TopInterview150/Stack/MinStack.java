package com.company.TopInterview150.Stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Integer> data;
    List<Integer> minValue;
    int size;
    int actualSize;

    public MinStack() {
        data = new ArrayList<>();
        minValue = new ArrayList<>();
        size = 0;
        actualSize = 0;
    }

    public void push(int val) {
        // if (actualSize == size) data.add(val);
        // else data.set(size, val);
        // int value;
        // if (size==0) {
        //     value = val;
        // } else {
        //     value = minValue.get(size)
        // }
        int value = size==0 ? val : minValue.get(size-1);
        int min = Math.min(val, value);
        if (actualSize == size) {
            data.add(val);
            minValue.add(min);
            actualSize++;
        } else {
            data.set(size, val);
            minValue.set(size, min);
        }

        size++;
    }

    public void pop() {
        // if (size > 0) size--;
        size--;
    }

    public int top() {
        return data.get(size-1);
    }

    public int getMin() {
        return minValue.get(size-1);
    }
}
