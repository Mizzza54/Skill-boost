package task332;

import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> path = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> pair: tickets) {
            if (!map.containsKey(pair.get(0))) {
                map.put(pair.get(0), new PriorityQueue<>());
            }
            map.get(pair.get(0)).add(pair.get(1));
        }

        dfs("JFK");
        Collections.reverse(path);
        return path;
    }

    private void dfs(String current) {
        if (map.containsKey(current)) {
            Queue<String> queue = map.get(current);
            while (!queue.isEmpty()) {
                dfs(queue.poll());
            }
        }
        path.add(current);
    }
}