package top_150_interview;

import java.util.*;

public class ZZZC_CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] require : prerequisites) {
            graph.get(require[1]).add(require[0]);
        }

        int[] visited = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, order, visited, i)) {
                return new int[0];
            }
        }

        Collections.reverse(order);
        return order.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean hasCycle(List<List<Integer>> graph, List<Integer> order, int[] visited, int source) {
        if (visited[source] == 1) return true;
        if (visited[source] == 2) return false;

        visited[source] = 1;
        for (int neighbor : graph.get(source)) {
            if (hasCycle(graph, order, visited, neighbor)) {
                return true;
            }
        }

        visited[source] = 2;
        order.add(source);
        return false;
    }


}
