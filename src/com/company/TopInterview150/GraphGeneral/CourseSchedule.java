package com.company.TopInterview150.GraphGeneral;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i=0; i<prerequisites.length; i++) {
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!canComplete(map, new HashSet<>(), i)) return false;
        }

        return true;
    }

    public boolean canComplete(Map<Integer, List<Integer>> map, Set<Integer> visited, int course) {
        if (visited.contains(course)) return false;

        List<Integer> list = map.get(course);
        if (list.isEmpty()) return true;

        visited.add(course);

        for (int i=0; i<list.size(); i++) {
            if (!canComplete(map, visited, list.get(i))) return false;
        }

        visited.remove(course);
        map.put(course, new ArrayList<>());

        return true;
    }
}
