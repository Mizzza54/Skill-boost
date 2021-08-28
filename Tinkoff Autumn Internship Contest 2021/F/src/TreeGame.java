import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Michael Gerasimov
 */
public class TreeGame {
    public void run() {
        FastReader scanner = new FastReader(System.in);

        List<List<Integer>> graphLucy = new ArrayList<>();
        int graphSizeLucy = scanner.nextInt();
        for (int i = 0; i < graphSizeLucy; i++) {
            graphLucy.add(new ArrayList<>());
        }
        for (int i = 0, u, v; i < graphSizeLucy - 1; i++) {
            u = scanner.nextInt() - 1;
            v = scanner.nextInt() - 1;
            graphLucy.get(u).add(v);
            graphLucy.get(v).add(u);
        }

        List<List<Integer>> graphDunya = new ArrayList<>();
        int graphSizeDunya = scanner.nextInt();
        for (int i = 0; i < graphSizeDunya; i++) {
            graphDunya.add(new ArrayList<>());
        }
        for (int i = 0, u, v; i < graphSizeDunya - 1; i++) {
            u = scanner.nextInt() - 1;
            v = scanner.nextInt() - 1;
            graphDunya.get(u).add(v);
            graphDunya.get(v).add(u);
        }

        int lucy = centerTree(graphLucy, graphSizeLucy);
        //System.err.println("lucy = " + lucy);
        int dunya = diameterTree(graphDunya, graphSizeDunya);
        //System.err.println("dunya = " + dunya);

        System.out.println(dunya < lucy ? "L" : "D");
    }

    private int centerTree(List<List<Integer>> graph, int graphSize) {
        int[] degree = new int[graphSize];
        for (List<Integer> list: graph) {
            for (int i: list) {
                degree[i]++;
            }
        }

        Set<Integer> leaves = new HashSet<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0 || degree[i] == 1) {
                leaves.add(i);
                degree[i] = 0;
            }
        }

        int count = leaves.size();
        while (count < graphSize) {
            Set<Integer> newLeaves = new HashSet<>();
            for (int v: leaves) {
                for (int u: graph.get(v)) {
                    if (degree[u] != 0) {
                        degree[u]--;
                        if (degree[u] == 1) {
                            newLeaves.add(u);
                        }
                    }
                }
            }
            count += newLeaves.size();
            leaves.clear();
            leaves.addAll(newLeaves);
        }

        int center = 0;
        for (int i : leaves) {
            center = i;
        }
        return bfs(graph, graphSize, center).first;
    }

    private int diameterTree(List<List<Integer>> graph, int graphSize) {
        return bfs(graph, graphSize, bfs(graph, graphSize, 0).second).first;
    }

    private Pair<Integer, Integer> bfs(List<List<Integer>> graph, int graphSize, int source) {
        int[] distance = new int[graphSize];
        Arrays.fill(distance, -1);
        distance[source] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int u : graph.get(v)) {
                if (distance[u] == -1) {
                    distance[u] = distance[v] + 1;
                    queue.add(u);
                }
            }
        }

        int max = 0, maxIndex = 0;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] > max) {
                max = distance[i];
                maxIndex = i;
            }
        }
        return new Pair<>(max, maxIndex);
    }

    public static void main(String[] args) {
        new TreeGame().run();
    }
}

class Pair<T, V> {
    T first;
    V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    FastReader(InputStream input) {
        br = new BufferedReader(new InputStreamReader(input));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}