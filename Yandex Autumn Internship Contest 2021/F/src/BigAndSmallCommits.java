import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NavigableSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @author Michael Gerasimov
 */
public class BigAndSmallCommits {
    FastReader scanner = new FastReader(System.in);
    int n, a, b;
    char[] history;
    NavigableSet<Integer> bigIndexes = new TreeSet<>();

    private void run() {
        n = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        history = scanner.next().toCharArray();
        for (int i = 0; i < history.length; i++) {
            if (history[i] == 'B') {
                bigIndexes.add(i);
            }
        }
        System.out.println(solve(0, n - 1, 0, Trend.LEFT));
    }

    private int solve(int l, int r, int sum, Trend trend) {
        if (l == r || r < 0 || l > r) {
//            switch (trend) {
//                case LEFT:
//                    sum -= history[l + 1] == 'S' ? a : b;
//                    break;
//                case RIGHT:
//                    sum -= history[l - 1] == 'S' ? a : b;
//                    break;
//            }
            return sum;
        }
        int m = (l + r) / 2;
//        if (r - l + 1 % 2 == 0) {
//            m = (l + r) / 2;
//        } else {
//            m = history[((l + r) / 2) - 1] == 'B'
//                    ? ((l + r) / 2)
//                    : ((l + r) / 2) - 1;
//        }
        boolean small;
        switch (trend) {
            case LEFT:
                small = isSmall(m, r, false, true);
                if (small && m != 0 && history[m - 1] == 'B' && history[m] != 'B') {
                    m--;
                }
                sum += small ? a : b;
                break;
            case RIGHT:
                small = isSmall(l, m, true, false);
                if (small && m != n - 1 && history[m + 1] == 'B' && history[m] != 'B') {
                    m++;
                }
                sum += small ? a : b;
                break;
        }
        return Math.max(solve(l, m, sum, Trend.LEFT), solve(m + 1, r, sum, Trend.RIGHT));
    }

    private boolean isSmall(int l, int r, boolean left, boolean right) {
        return bigIndexes.subSet(l, left, r, right).isEmpty();
    }

    public static void main(String[] args) {
        new BigAndSmallCommits().run();
    }
}

enum Trend {
    LEFT, RIGHT
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
