package top_150_interview;

import java.util.*;

public class ZZZB_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }
    public boolean hasCycle(List<List<Integer>> graph, int[] visited, int source) {
        if (visited[source] == 1) return true;
        if (visited[source] == 2) return false;

        visited[source] = 1;
        for (int neighbor : graph.get(source)) {
            if (hasCycle(graph, visited, neighbor)) {
                return true;
            }
        }

        visited[source] = 2;
        return false;
    }
}
