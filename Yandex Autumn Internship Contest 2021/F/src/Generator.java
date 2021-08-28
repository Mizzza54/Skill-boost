import java.util.function.Consumer;

/**
 * @author Michael Gerasimov
 */
public class Generator {

    public static void main(String[] args) {
        printForPattern("xxxx", System.out::println);
    }

    private static void printForPattern(String pattern, Consumer<CharSequence> consumer) {
        printForPattern(pattern, new StringBuilder(), consumer);
    }

    private static void printForPattern(String pattern, StringBuilder sb, Consumer<CharSequence> consumer) {
        int length = sb.length();
        if (pattern.length() == length) {
            consumer.accept(sb);
            return;
        }
        char ch = pattern.charAt(length);
        if (ch == 'x' || ch == 'S') {
            sb.append('S');
            printForPattern(pattern, sb, consumer);
            sb.setLength(length);
        }
        if (ch == 'x' || ch == 'B') {
            sb.append('B');
            printForPattern(pattern, sb, consumer);
            sb.setLength(length);
        }
    }
}
