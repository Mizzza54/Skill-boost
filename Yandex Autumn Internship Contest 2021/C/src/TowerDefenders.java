import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @author Michael Gerasimov
 */
public class TowerDefenders {
    FastReader scanner = new FastReader(System.in);
    int n, m;
    long[] plates;
    Set<Long> people = new TreeSet<>();
    Set<SunnyPlace> sunnyPlaces = new TreeSet<>();

    private void run() {
        n = scanner.nextInt();
        plates = new long[n];
        m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            plates[i] = scanner.nextLong();
        }
        for (int i = 0; i < m; i++) {
            people.add(scanner.nextLong());
        }
        foundSunnyPlaces();
        int count = 0;
        for (SunnyPlace sunnyPlace: sunnyPlaces) {
            for (long human : people) {
                if (sunnyPlace.length >= human) {
                    people.remove(human);
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    private void foundSunnyPlaces() {
        sunnyPlaces.add(new SunnyPlace(n - 1, plates[n - 1]));
        long maxLength = plates[n - 1];
        for (int i = n - 2; i > -1; i--) {
            if (plates[i] > maxLength) {
                sunnyPlaces.add(new SunnyPlace(i, plates[i] - maxLength));
                maxLength = plates[i];
            }
        }
    }

    public static void main(String[] args) {
        new TowerDefenders().run();
    }
}

class SunnyPlace implements Comparable<SunnyPlace> {
    int index;
    long length;

    public SunnyPlace(int index, long length) {
        this.index = index;
        this.length = length;
    }

    @Override
    public String toString() {
        return "SunnyPlace{" +
                "index=" + index +
                ", length=" + length +
                '}';
    }

    @Override
    public int compareTo(SunnyPlace o) {
        return length != o.length
                ? Long.compare(length, o.length)
                : Integer.compare(index, o.index);
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

    long nextLong() {
        return Long.parseLong(next());
    }
}