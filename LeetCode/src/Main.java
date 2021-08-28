import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Gerasimov
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(func("avt", "b"));
    }
    public static String func(String t, String s) {
        if (t.length() < s.length()) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            tMap.put(tChars[i], tMap.getOrDefault(tChars[i], 0) + 1);
            sMap.put(sChars[i], sMap.getOrDefault(sChars[i], 0) + 1);
        }

        int count = 0;
        for (char ch: sMap.keySet()) {
            count = Math.abs(tMap.getOrDefault(ch, 0) - sMap.getOrDefault(ch, 0)) != 0 ? count + 1 : count;
        }

        for (int i = s.length(), start = 0; i < t.length(); i++, start++) {
            if (count == 0) {
                return t.substring(start, i);
            }


            if (Math.abs(sMap.getOrDefault(tChars[start], 0) - (tMap.get(tChars[start]) - 1)) == 0) {
                count--;
            }
            if (Math.abs(sMap.getOrDefault(tChars[i], 0) - (tMap.get(tChars[i]) + 1)) == 0) {
                count--;
            }

            if (Math.abs(sMap.getOrDefault(tChars[start], 0) - (tMap.get(tChars[start]))) == 0) {
                count++;
            }
            if (Math.abs(sMap.getOrDefault(tChars[i], 0) - (tMap.get(tChars[i]))) == 0) {
                count++;
            }
            tMap.put(tChars[start], tMap.getOrDefault(tChars[start], 1) - 1);
            tMap.put(tChars[i], tMap.getOrDefault(tChars[i], 1) + 1);
        }

        return "";
    }
}
