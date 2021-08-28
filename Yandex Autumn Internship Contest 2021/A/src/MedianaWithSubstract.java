import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Michael Gerasimov
 */
public class MedianaWithSubstract {
    FastReader scanner = new FastReader(System.in);
    int[] array = new int[3];
    boolean[] result = new boolean[3];

    private void run() {
        array[0] = scanner.nextInt();
        array[1] = scanner.nextInt();
        array[2] = scanner.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (isMediana(i)) {
                result[i] = true;
            } else {
                for (int j = 0; j < array.length; j++) {
                    for (int k = 0; k < array.length; k++) {
                        if (j == k) {
                            continue;
                        }
                        change(j, k);
                        if (isMediana(i)) {
                            result[i] = true;
                            reverseChange(j, k);
                            break;
                        }
                        reverseChange(j, k);
                    }
                }
            }
        }

        for (boolean b : result) {
            System.out.println(b ? "Yes" : "No");
        }
    }

    private void change(int i, int j) {
        array[i] -= array[j];
    }

    private void reverseChange(int i, int j) {
        array[i] += array[j];
    }

    private boolean isMediana(int i) {
        switch (i) {
            case 0:
                return array[i] >= array[1] && array[i] <= array[2] || array[i] <= array[1] && array[i] >= array[2];
            case 1:
                return array[i] >= array[0] && array[i] <= array[2] || array[i] <= array[0] && array[i] >= array[2];
            case 2:
                return array[i] >= array[1] && array[i] <= array[0] || array[i] <= array[1] && array[i] >= array[0];
        }
        return false;
    }

    public static void main(String[] args) {
        new MedianaWithSubstract().run();
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
