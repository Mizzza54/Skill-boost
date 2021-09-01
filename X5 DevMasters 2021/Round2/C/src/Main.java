import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @author Michael Gerasimov
 */
public class Main {
    public void run() {

    }

    private int combinations(int n, int k) {
        if (k == n || k == 0) {
            return 1;
        } else {
            return IntStream.rangeClosed(n - k + 1, n).reduce((x, y) -> x * y).getAsInt() / getFactorial(k);
        }
    }

    private int getFactorial(int f) {
        if (f <= 1) {
            return 1;
        } else {
            return IntStream.rangeClosed(2, f).reduce((x, y) -> x * y).getAsInt();
        }
    }

    public static void main(String[] args) {
        new Main().run();
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
