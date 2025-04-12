package com.company.TopInterview150.GraphBFS;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);

        if (!bankSet.contains(endGene)) return -1;

        Queue<Gene> que = new LinkedList<>();
        que.add(new Gene(startGene, 0));
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        while (!que.isEmpty()) {
            Gene gene = que.remove();

            if (gene.value.equals(endGene)) return gene.steps;
            StringBuilder sb = new StringBuilder(gene.value);

            for (int i=0; i<8; i++) {
                char c = sb.charAt(i);
                sb.setCharAt(i, 'A');
                addToQueueIfValid(que, sb.toString(), gene.steps, bankSet, visited);
                sb.setCharAt(i, 'C');
                addToQueueIfValid(que, sb.toString(), gene.steps, bankSet, visited);
                sb.setCharAt(i, 'G');
                addToQueueIfValid(que, sb.toString(), gene.steps, bankSet, visited);
                sb.setCharAt(i, 'T');
                addToQueueIfValid(que, sb.toString(), gene.steps, bankSet, visited);
                sb.setCharAt(i, c);
            }
        }
        return -1;
    }

    private void addToQueueIfValid(Queue<Gene> que, String value, int steps, Set<String> bankSet, Set<String> visited) {
        if (bankSet.contains(value) && !visited.contains(value)) {
            que.add(new Gene(value, steps+1));
            visited.add(value);
        }
    }

    class Gene {
        String value;
        int steps;

        Gene(String value, int steps) {
            this.value = value;
            this.steps = steps;
        }
    }
}
