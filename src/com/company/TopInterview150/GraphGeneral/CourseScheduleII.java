package com.company.TopInterview150.GraphGeneral;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] e : prerequisites) {
            map.get(e[0]).add(e[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        int[] res = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (!complete(map, visited, resSet, res, i)) return new int[0];
        }

        return res;
    }

    private boolean complete(Map<Integer, List<Integer>> map, Set<Integer> visited, Set<Integer> resSet, int[] res, int course) {
        if (visited.contains(course)) return false;
        if (resSet.contains(course)) return true;

        visited.add(course);
        List<Integer> courseList = map.get(course);
        for (int e : courseList) {
            if (!complete(map, visited, resSet, res, e)) return false;
        }

        visited.remove(course);
        resSet.add(course);
        res[resSet.size()-1] = course;
        return true;
    }
}
