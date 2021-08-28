import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Michael Gerasimov
 */
public class CheckingDivisibility {

    private void run() {
        FastReader scanner = new FastReader(System.in);
        String string = scanner.next();
        boolean[] result = new boolean[10];
        result[0] = true;
        result[1] = check2(string);
        result[2] = check3(string);
        result[3] = check4(string);
        result[4] = check5(string);
        result[5] = check6(string);
        result[6] = check7(string);
        result[7] = check8(string);
        result[8] = check9(string);
        result[9] = check10(string);

        for (int i = 0; i < 10; i++) {
            if (result[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }

    private boolean check2(final String string) {
        if (string.charAt(string.length() - 1) == '*') {
            return false;
        } else {
            return Byte.parseByte(String.valueOf(string.charAt(string.length() - 1))) % 2 == 0;
        }
    }

    private boolean check3(final String string) {
        return false;
    }

    private boolean check4(final String string) {
        if (string.length() == 2
                || string.charAt(string.length() - 1) == '*'
                ||  string.charAt(string.length() - 2) == '*') {
            return false;
        } else {
            return Byte.parseByte(string.substring(string.length() - 2)) % 4 == 0;
        }
    }

    private boolean check5(final String string) {
        return string.charAt(string.length() - 1) == '0' || string.charAt(string.length() - 1) == '5';
    }

    private boolean check6(final String string) {
        return false;
    }

    private boolean check7(final String string) {
        return false;
    }

    private boolean check8(final String string) {
        if (string.length() < 3
                || string.charAt(string.length() - 3) == '*'
                || string.charAt(string.length() - 2) == '*'
                || string.charAt(string.length() - 1) == '*') {
            return false;
        } else {
            return Short.parseShort(string.substring(string.length() - 3)) % 8 == 0;
        }
    }

    private boolean check9(final String string) {
        return false;
    }

    private boolean check10(final String string) {
        return string.charAt(string.length() - 1) == '0';
    }

    public static void main(String[] args) {
        new CheckingDivisibility().run();
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
}