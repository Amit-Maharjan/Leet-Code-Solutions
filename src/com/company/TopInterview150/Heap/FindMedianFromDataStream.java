package com.company.TopInterview150.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> smallHeap; // Max Heap
    PriorityQueue<Integer> largeHeap; // Min Heap

    public FindMedianFromDataStream() {
        largeHeap = new PriorityQueue<>();
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        smallHeap.add(num);

        if (!smallHeap.isEmpty() && !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) {
            largeHeap.add(smallHeap.remove());
        }

        // Uneven size
        if (smallHeap.size() > largeHeap.size() + 1) {
            largeHeap.add(smallHeap.remove());
        }

        if (largeHeap.size() > smallHeap.size() + 1) {
            smallHeap.add(largeHeap.remove());
        }
    }

    public double findMedian() {
        if (smallHeap.size() > largeHeap.size()) return smallHeap.peek();
        if (smallHeap.size() < largeHeap.size()) return largeHeap.peek();
        return (double)(smallHeap.peek()+largeHeap.peek()) / 2;
    }
}
