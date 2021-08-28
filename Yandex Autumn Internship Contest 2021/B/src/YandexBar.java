import java.util.Scanner;

/**
 * @author Michael Gerasimov
 */
public class YandexBar {
    Scanner scanner = new Scanner(System.in);
    int n, m, k;
    char[][] description;
    Cocktail[] composition;

    private void run() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        description = new char[n][m];
        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine();
            description[i] = string.toCharArray().clone();
        }

        k = scanner.nextInt();
        scanner.nextLine();
        composition = new Cocktail[k];
        for (int i = 0; i < k; i++) {
            String string = scanner.nextLine();
            String[] splitted = string.split(" ");
            composition[i] = new Cocktail(splitted[0], Integer.parseInt(splitted[1]), splitted[2].charAt(0));
        }

        for (int i = n - 2, layer = 0, count = 0; i > -1; i--) {

            if (count == composition[layer].count) {
                layer++;
                count = 0;
                if (layer == k) {
                    break;
                }
            }

            for (int j = 0; j < m; j++) {
                if (description[i][j] == ' ') {
                    description[i][j] = composition[layer].symbol;
                }
            }
            count++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(description[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new YandexBar().run();
    }
}

class Cocktail {
    String name;
    int count;
    char symbol;

    public Cocktail(String name, int count, char symbol) {
        this.name = name;
        this.count = count;
        this.symbol = symbol;
    }
}
