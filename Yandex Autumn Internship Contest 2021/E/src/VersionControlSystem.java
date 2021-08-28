import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Michael Gerasimov
 */
public class VersionControlSystem {
    FastReader scanner = new FastReader(System.in);
    int na, nb, nc, q;
    Rule[] rules;

    private void run() {
        na = scanner.nextInt();
        nb = scanner.nextInt();
        nc = scanner.nextInt();
        q = scanner.nextInt();
        rules = new Rule[q];
        for (int i = 0; i < q; i++) {
            rules[i] = new Rule(mapIndexToModule(scanner.nextInt()), scanner.nextInt(), mapIndexToModule(scanner.nextInt()), scanner.nextInt());
        }
        System.out.println(Arrays.toString(rules));
    }

    private Module mapIndexToModule(int index) {
        switch (index) {
            case 1:
                return Module.A;
            case 2:
                return Module.B;
            case 3:
                return Module.C;
        }
        return null;
    }

    public static void main(String[] args) {
        new VersionControlSystem().run();
    }
}

class Rule {
    Module parentModule, dependencyModule;
    int parentVersion, dependencyVersion;

    public Rule(Module parentModule, int parentVersion, Module dependencyModule, int dependencyVersion) {
        this.parentModule = parentModule;
        this.parentVersion = parentVersion;
        this.dependencyModule = dependencyModule;
        this.dependencyVersion = dependencyVersion;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "parentModule=" + parentModule +
                ", dependencyModule=" + dependencyModule +
                ", parentVersion=" + parentVersion +
                ", dependencyVersion=" + dependencyVersion +
                '}';
    }
}

enum Module {
    A(1),
    B(2),
    C(3);

    int index;

    Module(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Module{" +
                "index=" + index +
                '}';
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