import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NavigableMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @author Michael Gerasimov
 */
public class BankCommission {
    public void run() {
        FastReader scanner = new FastReader(System.in);
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        double result = 0;
        while (map.size() != 1 || map.firstEntry().getValue() != 1) {
            int aKey = pollMin(map);
            int bKey = pollMin(map);
            int newKey = (aKey + bKey);
            result += newKey * 0.05;
            map.put(newKey, map.getOrDefault(newKey, 0) + 1);
        }
        System.out.println(result);
    }

    private int pollMin(NavigableMap<Integer, Integer> map) {
        int key = map.firstKey();
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
        return key;
    }

    public static void main(String[] args) {
        new BankCommission().run();
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