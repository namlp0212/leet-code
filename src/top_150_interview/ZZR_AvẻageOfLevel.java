package top_150_interview;

import java.util.*;
public class ZZR_AvẻageOfLevel {
    class NodeLevel {
        public TreeNode node;
        public Integer level;

        public NodeLevel() {

        }
        public NodeLevel(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        if (root == null) return res;

        Queue<NodeLevel> q = new ArrayDeque<>();
        Map<Integer, List<NodeLevel>> map = new HashMap<>();
        NodeLevel nodeLevel = new NodeLevel(root, 0);
        q.add(nodeLevel);
        List<NodeLevel> list;
        int maxLevel = 0;
        while (!q.isEmpty()) {
            NodeLevel top = q.poll();
            maxLevel = Math.max(maxLevel, top.level);

            // put to map
            if (map.containsKey(top.level)) {
                list = map.get(top.level);
                list.add(top);
            } else {
                list = new ArrayList<>();
                list.add(top);
                map.put(top.level, list);
            }
            // put to queue
            if (top.node.left != null) {
                NodeLevel nl = new NodeLevel(top.node.left, top.level + 1);
                q.add(nl);
            }
            if (top.node.right != null) {
                NodeLevel nl = new NodeLevel(top.node.right, top.level + 1);
                q.add(nl);
            }
        }

        // loop map
        Double avg;
        for (int i = 0; i <= maxLevel; i++) {
            list = map.get(i);
            res.add(list.stream().map(nl -> nl.node.val).mapToInt(Integer::intValue).average().getAsDouble());
        }

        return res;
    }
}
