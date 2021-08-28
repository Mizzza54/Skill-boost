import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.Timeout;
import org.junit.runner.Description;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;

/**
 * @author Michael Gerasimov
 */
public class TreeGameTest {
    private static final Path TESTS_DIR = Path.of("src", "test");
    private static final TreeGame solution = new TreeGame();

    private final InputStream originalInput = System.in;
    private final PrintStream originalOutput = System.out;

    private final OutputStream dataOutput = new ByteArrayOutputStream();

    protected String testMethodName;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Rule
    public TestRule watcher = watcher(description -> {
        testMethodName = description.getMethodName();
        System.err.println("=== Running " + testMethodName);
    });

    protected static TestWatcher watcher(final Consumer<Description> watcher) {
        return new TestWatcher() {
            @Override
            protected void starting(final Description description) {
                watcher.accept(description);
            }
        };
    }

    public Path getTestPath() {
        return TESTS_DIR.resolve(testMethodName + ".txt");
    }


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
    public void simpleTest1() throws IOException {
        loadData(Files.readString(getTestPath()));
        solution.run();
        Assert.assertEquals("D" , dataOutput.toString().trim());
    }

    @Test
    public void simpleTest2() throws IOException {
        loadData(Files.readString(getTestPath()));
        solution.run();
        Assert.assertEquals("L" , dataOutput.toString().trim());
    }

    @Test
    public void glebTest1() throws IOException {
        loadData(Files.readString(getTestPath()));
        solution.run();
        Assert.assertEquals("L" , dataOutput.toString().trim());
    }

    @Test
    public void glebTest2() throws IOException {
        loadData(Files.readString(getTestPath()));
        solution.run();
        Assert.assertEquals("D" , dataOutput.toString().trim());
    }

    @Test
    public void sameTreeTest1() throws IOException {
        loadData(Files.readString(getTestPath()));
        solution.run();
        Assert.assertEquals("D" , dataOutput.toString().trim());
    }
}