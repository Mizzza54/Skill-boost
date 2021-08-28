import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael Gerasimov
 */
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final String J = reader.readLine();
        final String S = reader.readLine();


        Set<Character> charsJ = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            charsJ.add(J.charAt(i));
        }

        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (charsJ.contains(S.charAt(i))) {
                result++;
            }
        }

        System.out.println(result);
    }
}
