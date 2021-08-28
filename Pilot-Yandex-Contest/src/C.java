import java.io.*;


/**
 * @author Michael Gerasimov
 */
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")), 15);
        PrintWriter writer = new PrintWriter("output.txt");
        int n = Integer.parseInt(scanner.readLine());
        if (n == 0) {
            return;
        }

        int prev = Integer.parseInt(scanner.readLine());
        writer.println(prev);
        for (int i = 1; i < n; i++) {
            int current = Integer.parseInt(scanner.readLine());
            if (current != prev) {
                writer.println(current);
                prev = current;
            }
            if (i % 10000 == 0) {
                System.gc();
            }
        }
        scanner.close();
        writer.close();
    }
}
