package top_150_interview;

import java.util.*;

public class ZZB_EvaluateDivision {

    class Node {
        String vertex;
        Double val;

        public Node() {
        }
        public Node(String vertex, Double val) {
            this.vertex = vertex;
            this.val = val;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            ans[i] = dfs(graph, queries.get(i));
        }
        return ans;
    }

    public double dfs(Map<String, Map<String, Double>> graph, List<String> query) {
        String source = query.get(0);
        String target = query.get(1);

        if (!graph.containsKey(source)) {
            return -1d;
        }

        Set<String> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(source, 1d));
        visited.add(source);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node.vertex.equals(target)) {
                return node.val;
            } else {
                Map<String, Double> edges = graph.get(node.vertex);

                if (edges != null) {
                    for (Map.Entry<String, Double> entry : edges.entrySet()) {
                        String vertex = entry.getKey();
                        Double val = entry.getValue();

                        if (!visited.contains(vertex)) {
                            stack.push(new Node(vertex, node.val * val));
                            visited.add(vertex);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> result = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String first = equation.get(0);
            String second = equation.get(1);
            Double val = values[i];
            if (result.containsKey(first)) {
                Map<String, Double> edge = result.get(first);
                edge.put(second, val);
            } else {
                Map<String, Double> edge = new HashMap<>();
                edge.put(second, val);
                result.put(first, edge);
            }

            if (result.containsKey(second)) {
                Map<String, Double> edge = result.get(second);
                edge.put(first, 1 / val);
            } else {
                Map<String, Double> edge = new HashMap<>();
                edge.put(first, 1 / val);
                result.put(second, edge);
            }
        }

        return result;
    }
}
