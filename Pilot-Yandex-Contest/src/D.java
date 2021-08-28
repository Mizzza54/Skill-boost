import java.io.*;

/**
 * @author Michale Gerasimov
 * start: 08.12.2019
 * @version -
 */
public class D {
    static PrintWriter writer;

    static {
        try {
            writer = new PrintWriter("output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")), 15);
        int n = Integer.parseInt(scanner.readLine());
        scanner.close();
        generate(n, 0, 0, "");
        writer.close();
    }

    public static void generate(int n, int count_open, int count_close, String ans) {
        if (count_open + count_close == 2 * n) {
            writer.println(ans);
            return;
        }
        if (count_open < n) {
            generate(n, count_open + 1, count_close, ans + "(");
        }
        if (count_open > count_close) {
            generate(n, count_open, count_close + 1, ans + ")");
        }
    }
}