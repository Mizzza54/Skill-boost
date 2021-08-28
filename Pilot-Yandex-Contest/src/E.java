import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Gerasimov
 */
public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in), 15);
        final String str1 = scanner.readLine();
        final String str2 = scanner.readLine();
        Map<Character, Integer> map1 = stringToMap(str1);
        Map<Character, Integer> map2 = stringToMap(str2);
        System.out.println((map1.equals(map2)) ? "1" : "0");
    }

    private static Map<Character, Integer> stringToMap(final String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: string.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        return map;
    }
}
