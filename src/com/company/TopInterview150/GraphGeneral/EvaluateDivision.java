package com.company.TopInterview150.GraphGeneral;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i=0; i<equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double res = values[i];

            map.putIfAbsent(a, new HashMap<>());
            map.get(a).put(b,res);
            map.putIfAbsent(b, new HashMap<>());
            map.get(b).put(a,1/res);
        }

        double[] result = new double[queries.size()];
        for (int i=0; i<queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            result[i] = calc(map, visited, a, b);
        }

        return result;
    }

    private double calc(Map<String, Map<String, Double>> map, Set<String> visited, String a, String b) {
        if (!map.containsKey(a)) return -1.0;
        if (map.get(a).containsKey(b)) return map.get(a).get(b);

        visited.add(a);
        for (Map.Entry<String, Double> submap : map.get(a).entrySet()) {
            if (!visited.contains(submap.getKey())) {
                double res = calc(map, visited, submap.getKey(), b);
                if (res!=-1.0) return submap.getValue() * res;
            }
        }
        return -1.0;
    }
}
