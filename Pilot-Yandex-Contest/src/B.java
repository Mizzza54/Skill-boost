import java.util.Scanner;

/**
 * @author Michael Gerasimov
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int current = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] == 1) {
                current++;
            } else {
                if (max < current) {
                    max = current;
                }
                current = 0;
            }
        }
        if (max < current) {
            max = current;
        }
        System.out.println(max);
    }
}
