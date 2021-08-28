import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Michael Gerasimov
 */
public class Equation {
    private void run() {
        FastReader scanner = new FastReader(System.in);
        int n = scanner.nextInt() + 1;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextDouble();
        }

        double l = -100, r = 100;
        double eps = 1E-6;
        while (true) {
            double x1 = (l + r - eps) / 2;
            double x2 = (l + r + eps) / 2;
            double f1 = evaluate(n, a, x1);
            double f2 = evaluate(n, a, x2);
            if (f1 < 1E-6 || f2 < 1E-6) {
                break;
            }
            if (f1 <= f2) {
                r = x2;
            } else {
                l = x1;
            }
        }
        System.out.println((l + r) / 2);
    }

    private double evaluate(int n, double[] a, double x) {
        double result = a[0];
        double currentX = x;
        for (int i = 1; i < n; i++) {
            result += a[i] * currentX;
            currentX *= x;
        }
        return Math.abs(result);
    }

    public static void main(String[] args) {
        new Equation().run();
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

    double nextDouble() {
        return Double.parseDouble(next());
    }
}