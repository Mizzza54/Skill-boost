import org.junit.*;
import org.junit.rules.Timeout;

import java.io.*;
import java.util.Random;

/**
 * @author Michael Gerasimov
 */
public class BankCommissionTest {
    private static final BankCommission solution = new BankCommission();

    private final InputStream originalInput = System.in;
    private final PrintStream originalOutput = System.out;

    private final OutputStream dataOutput = new ByteArrayOutputStream();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(dataOutput));
    }

    @After
    public void restoreStreams() {
        System.setIn(originalInput);
        System.setOut(originalOutput);
    }

    public void loadData(final String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @Test
    public void simpleTest1() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 2;
        int amount1 = 1;
        int amount2 = 1;
        stringBuilder.append(String.format("%d%n", n));
        stringBuilder.append(String.format("%d %d%n", amount1, amount2));
        loadData(stringBuilder.toString());
        solution.run();
        Assert.assertEquals(0.1 , Double.parseDouble(dataOutput.toString().trim()), 0.000001);
    }

    @Test
    public void simpleTest2() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 2;
        int amount1 = 1;
        int amount2 = 10;
        stringBuilder.append(String.format("%d%n", n));
        stringBuilder.append(String.format("%d %d%n", amount1, amount2));
        loadData(stringBuilder.toString());
        solution.run();
        Assert.assertEquals(0.55, Double.parseDouble(dataOutput.toString().trim()), 0.000001);
    }

    @Test
    public void simpleTest3() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 4;
        int amount4 = 13;
        int amount3 = 12;
        int amount2 = 11;
        int amount1 = 10;
        stringBuilder.append(String.format("%d%n", n));
        stringBuilder.append(String.format("%d %d %d %d%n", amount1, amount2, amount3, amount4));
        loadData(stringBuilder.toString());
        solution.run();
        Assert.assertEquals(4.6, Double.parseDouble(dataOutput.toString().trim()), 0.000001);
    }

    @Test
    public void singleAmountTest() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 1;
        int amount1 = 100;
        stringBuilder.append(String.format("%d%n", n));
        stringBuilder.append(String.format("%d%n", amount1));
        loadData(stringBuilder.toString());
        solution.run();
        Assert.assertEquals(0, Double.parseDouble(dataOutput.toString().trim()), 0.000001);
    }

    @Test
    public void maxAmountValueTest() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 16;
        stringBuilder.append(String.format("%d%n", n));
        stringBuilder.append(String.valueOf(String.format("%d ", 10000)).repeat(n));
        loadData(stringBuilder.toString());
        solution.run();
        Assert.assertEquals(32000, Double.parseDouble(dataOutput.toString().trim()), 0.000001);
    }

    @Test
    public void maxTimeTest() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 100000;
        Random random = new Random();
        stringBuilder.append(String.format("%d%n", n));
        for (int i = 0; i < n; i++) {
            int value = random.nextInt() % 10000;
            stringBuilder.append(String.format("%d ", value));
        }
        loadData(stringBuilder.toString());
        solution.run();
    }
}