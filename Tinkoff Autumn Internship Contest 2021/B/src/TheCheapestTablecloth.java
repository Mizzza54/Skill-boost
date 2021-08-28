import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Michael Gerasimov
 */
public class TheCheapestTablecloth {

    public void run() {
        FastReader scanner = new FastReader(System.in);
        short n = scanner.nextShort();
        short widthTable = scanner.nextShort();
        short heightTable = scanner.nextShort();
        short minCost = 2000;
        for (int i = 0; i < n; i++) {
            short width = scanner.nextShort();
            short height = scanner.nextShort();
            short cost = scanner.nextShort();
            if (isValid(widthTable, heightTable, width, height) && minCost > cost) {
                minCost = cost;
            }
        }
        System.out.println(minCost);
    }

    private boolean isValid(short widthTable, short heightTable, short width, short height) {
        return (widthTable <= width && heightTable <= height) || (widthTable <= height && heightTable <= width);
    }

    public static void main(String[] args) {
        new TheCheapestTablecloth().run();
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