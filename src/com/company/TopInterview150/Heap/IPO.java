package com.company.TopInterview150.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class IPO {
    class Project {
        int profit;
        int capital;

        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<Project> maxProfitHeap = new PriorityQueue<>((a, b) -> b.profit-a.profit);
        Queue<Project> minCapitalHeap = new PriorityQueue<>((a,b) -> a.capital-b.capital);

        for (int i=0; i<profits.length; i++) {
            minCapitalHeap.add(new Project(profits[i], capital[i]));
        }

        for (int i=0; i<k; i++) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital<=w) {
                maxProfitHeap.add(minCapitalHeap.remove());
            }

            if (maxProfitHeap.isEmpty()) break;
            w += maxProfitHeap.remove().profit;
        }

        return w;
    }
}
