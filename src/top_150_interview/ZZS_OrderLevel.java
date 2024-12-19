package top_150_interview;

import java.util.*;
import java.util.stream.Collectors;

public class ZZS_OrderLevel {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

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

        // lood map
        List<Integer> subList;
        for (int i = 0; i <= maxLevel; i++) {
            list = map.get(i);
            subList = list.stream().map(item -> item.node.val).collect(Collectors.toList());
            res.add(subList);
        }

        return res;
    }
}
