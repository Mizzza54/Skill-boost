import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Michael Gerasimov
 */
public class LizaAndSweets {

    private void run() {
        FastReader scanner = new FastReader(System.in);
        short a = scanner.nextShort();
        short b = scanner.nextShort();
        short n = scanner.nextShort();
        System.out.println((a + b) > n ? n : a + b);
    }

    public static void main(String[] args) {
        new LizaAndSweets().run();
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

    short nextShort() {
        return Short.parseShort(next());
    }
}