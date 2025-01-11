package top_150_interview;

import java.util.*;

public class ZZZE_MinimumGenericMutation {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        int steps = 0;
        char[] genes = {'A', 'C', 'G', 'T'};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(end)) return steps;

                char[] currentArray = current.toCharArray();
                for (int j = 0; j < currentArray.length; j++) {
                    char oldChar = currentArray[j];
                    for (char gene : genes) {
                        currentArray[j] = gene;
                        String next = new String(currentArray);
                        if (bankSet.contains(next)) {
                            queue.add(next);
                            bankSet.remove(next); // Mark as visited
                        }
                    }
                    currentArray[j] = oldChar;
                }
            }
            steps++;
        }

        return -1;
    }
}
