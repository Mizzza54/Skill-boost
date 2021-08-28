import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * @author Michael Gerasimov
 */
public class TheCheapestTableclothTest {
    private static final TheCheapestTablecloth solution = new TheCheapestTablecloth();

    private final InputStream originalInput = System.in;
    private final PrintStream originalOutput = System.out;

    private final OutputStream dataOutput = new ByteArrayOutputStream();

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
        int n = 3;
        int W = 5, H = 6;
        int w1 = 5, h1 = 4, c1 = 20;
        int w2 = 6, h2 = 7, c2 = 10;
        int w3 = 6, h3 = 5, c3 = 5;
        stringBuilder.append(String.format("%d%n", n));
        stringBuilder.append(String.format("%d %d%n", W, H));
        stringBuilder.append(String.format("%d %d %d%n", w1, h1, c1));
        stringBuilder.append(String.format("%d %d %d%n", w2, h2, c2));
        stringBuilder.append(String.format("%d %d %d%n", w3, h3, c3));
        loadData(stringBuilder.toString());
        solution.run();
        Assert.assertEquals(5, Integer.parseInt(dataOutput.toString().trim()));
    }

    @Test
    public void simpleTest2() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 1;
        int W = 3, H = 6;
        int w1 = 5, h1 = 4, c1 = 20;
        stringBuilder.append(String.format("%d%n", n));
        stringBuilder.append(String.format("%d %d%n", W, H));
        stringBuilder.append(String.format("%d %d %d%n", w1, h1, c1));
        loadData(stringBuilder.toString());
        solution.run();
        Assert.assertEquals(2000, Integer.parseInt(dataOutput.toString().trim()));
    }

    @Test
    public void sameSizeTest() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 1;
        int W = 3, H = 6;
        int w1 = 3, h1 = 6, c1 = 20;
        stringBuilder.append(String.format("%d%n", n));
        stringBuilder.append(String.format("%d %d%n", W, H));
        stringBuilder.append(String.format("%d %d %d%n", w1, h1, c1));
        loadData(stringBuilder.toString());
        solution.run();
        Assert.assertEquals(2000, Integer.parseInt(dataOutput.toString().trim()));
    }

    @Test
    public void differentSizeTest() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 1;
        int W = 3, H = 6;
        int w1 = 4, h1 = 7, c1 = 20;
        stringBuilder.append(String.format("%d%n", n));
        stringBuilder.append(String.format("%d %d%n", W, H));
        stringBuilder.append(String.format("%d %d %d%n", w1, h1, c1));
        loadData(stringBuilder.toString());
        solution.run();
        Assert.assertEquals(20, Integer.parseInt(dataOutput.toString().trim()));
    }

    @Test
    public void reverseTableTest() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 1;
        int W = 6, H = 3;
        int w1 = 4, h1 = 7, c1 = 20;
        stringBuilder.append(String.format("%d%n", n));
        stringBuilder.append(String.format("%d %d%n", W, H));
        stringBuilder.append(String.format("%d %d %d%n", w1, h1, c1));
        loadData(stringBuilder.toString());
        solution.run();
        Assert.assertEquals(20, Integer.parseInt(dataOutput.toString().trim()));
    }

    @Test
    public void reverseTableclothTest() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 1;
        int W = 3, H = 6;
        int w1 = 7, h1 = 4, c1 = 20;
        stringBuilder.append(String.format("%d%n", n));
        stringBuilder.append(String.format("%d %d%n", W, H));
        stringBuilder.append(String.format("%d %d %d%n", w1, h1, c1));
        loadData(stringBuilder.toString());
        solution.run();
        Assert.assertEquals(20, Integer.parseInt(dataOutput.toString().trim()));
    }

    @Test
    public void sameTableclothTest() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 3;
        int W = 3, H = 6;
        int w1 = 7, h1 = 4, c1 = 30;
        int w2 = 4, h2 = 7, c2 = 20;
        int w3 = 7, h3 = 4, c3 = 10;
        stringBuilder.append(String.format("%d%n", n));
        stringBuilder.append(String.format("%d %d%n", W, H));
        stringBuilder.append(String.format("%d %d %d%n", w1, h1, c1));
        stringBuilder.append(String.format("%d %d %d%n", w2, h2, c2));
        stringBuilder.append(String.format("%d %d %d%n", w3, h3, c3));
        loadData(stringBuilder.toString());
        solution.run();
        Assert.assertEquals(10, Integer.parseInt(dataOutput.toString().trim()));
    }
}