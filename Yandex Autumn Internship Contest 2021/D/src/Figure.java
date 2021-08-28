import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Michael Gerasimov
 */

public class Figure {
    FastReader scanner = new FastReader(System.in);
    int n, m, k;
    Node[] nodes;
    Node head, current;


    private void run() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        nodes = new Node[k];
        for (int i = 0; i < k; i++) {
            nodes[i] = new Node(scanner.nextInt(), scanner.nextInt());
        }
        fillNeighbors();

        if (k == 0) {
            System.out.println("0 0 0 0");
        } else {
            int firstCatCount = 0;
            int secondCatCount = 0;
            int thirdCatCount = 0;
            int fourthCatCount = 0;
            int x = nodes[0].x;
            int y = nodes[0].y;
            if (y == current.y && x > current.x) {
                current.right = head;
                current.right.left = current;
                current = current.right;
            } else if (y == current.y && x < current.x) {
                current.left = head;
                current.left.right = current;
                current = current.left;
            } else if (x == current.x && y > current.y) {
                current.up = head;
                current.up.down = current;
                current = current.up;
            } else if (x == current.x && y < current.y) {
                current.down = head;
                current.down.up = current;
                current = current.down;
            }

            Node prev = head;
            Node tmpHead = head.next((Node) null);

            int i;
            int[][] array;
            Node tmm;
            for (array = new int[n][m]; !tmpHead.equals(head); prev = tmm) {
                if (tmpHead.x == prev.x) {
                    if (tmpHead.y > prev.y) {
                        for (i = prev.y; i <= tmpHead.y; ++i) {
                            array[tmpHead.x - 1][i - 1] = 1;
                        }
                    } else {
                        for (i = prev.y; i >= tmpHead.y; --i) {
                            array[tmpHead.x - 1][i - 1] = 1;
                        }
                    }

                    secondCatCount += Math.abs(tmpHead.y - prev.y) - 1;
                }

                if (tmpHead.y == prev.y) {
                    if (tmpHead.x > prev.x) {
                        for (i = prev.x; i <= tmpHead.x; ++i) {
                            array[i - 1][tmpHead.y - 1] = 1;
                        }
                    } else {
                        for (i = prev.x; i >= tmpHead.x; --i) {
                            array[i - 1][tmpHead.y - 1] = 1;
                        }
                    }

                    secondCatCount += Math.abs(tmpHead.x - prev.x) - 1;
                }

                if (prev.up == prev.next(tmpHead)) {
                    if (tmpHead.x > prev.x) {
                        ++thirdCatCount;
                    } else {
                        ++fourthCatCount;
                    }
                }

                if (prev.left == prev.next(tmpHead)) {
                    if (prev.y > tmpHead.y) {
                        ++fourthCatCount;
                    } else {
                        ++thirdCatCount;
                    }
                }

                if (prev.down == prev.next(tmpHead)) {
                    if (tmpHead.x < prev.x) {
                        ++thirdCatCount;
                    } else {
                        ++fourthCatCount;
                    }
                }

                if (prev.right == prev.next(tmpHead)) {
                    if (tmpHead.y < prev.y) {
                        ++thirdCatCount;
                    } else {
                        ++fourthCatCount;
                    }
                }

                tmm = tmpHead;
                tmpHead = tmpHead.next(prev);
            }

            if (tmpHead.x == prev.x) {
                if (tmpHead.y > prev.y) {
                    for (i = prev.y; i <= tmpHead.y; ++i) {
                        array[tmpHead.x - 1][i - 1] = 1;
                    }
                } else {
                    for (i = prev.y; i >= tmpHead.y; --i) {
                        array[tmpHead.x - 1][i - 1] = 1;
                    }
                }

                secondCatCount += Math.abs(tmpHead.y - prev.y) - 1;
            }

            if (tmpHead.y == prev.y) {
                if (tmpHead.x > prev.x) {
                    for (i = prev.x; i <= tmpHead.x; ++i) {
                        array[i - 1][tmpHead.y - 1] = 1;
                    }
                } else {
                    for (i = prev.x; i >= tmpHead.x; --i) {
                        array[i - 1][tmpHead.y - 1] = 1;
                    }
                }

                secondCatCount += Math.abs(tmpHead.x - prev.x) - 1;
            }

            if (prev.up == prev.next(tmpHead)) {
                if (tmpHead.x > prev.x) {
                    ++thirdCatCount;
                } else {
                    ++fourthCatCount;
                }
            }

            if (prev.left == prev.next(tmpHead)) {
                if (prev.y > tmpHead.y) {
                    ++fourthCatCount;
                } else {
                    ++thirdCatCount;
                }
            }

            if (prev.down == prev.next(tmpHead)) {
                if (tmpHead.x < prev.x) {
                    ++thirdCatCount;
                } else {
                    ++fourthCatCount;
                }
            }

            if (prev.right == prev.next(tmpHead)) {
                if (tmpHead.y < prev.y) {
                    ++thirdCatCount;
                } else {
                    ++fourthCatCount;
                }
            }

            tmpHead.next(prev);

            for (i = 0; i < n; ++i) {
                int oneCount = 0;
                int countt = 0;

                for (int j = 0; j < m; ++j) {
                    if (array[i][j] == 1 && oneCount == 0) {
                        ++oneCount;

                        while (j != m - 1 && array[i][j + 1] == 1) {
                            ++j;
                        }
                    } else if (array[i][j] == 1 && oneCount == 1) {
                        firstCatCount += countt;

                        for (oneCount = 0; j != m - 1 && array[i][j + 1] == 1; ++j) {
                        }

                        countt = 0;
                    } else if (oneCount == 1 && array[i][j] == 0) {
                        ++countt;
                    }
                }
            }

            System.out.print(firstCatCount + " ");
            System.out.print(secondCatCount + " ");
            System.out.print(thirdCatCount + " ");
            System.out.println(fourthCatCount);
        }
    }

    private void fillNeighbors() {
        for (int i = 0; i < k; i++) {
            int x = nodes[i].x;
            int y = nodes[i].y;
            if (head == null) {
                head = nodes[i];
                current = head;
            } else if (y == current.y && x > current.x) {
                current.right = nodes[i];
                current.right.left = current;
                current = current.right;
            } else if (y == current.y && x < current.x) {
                current.left = nodes[i];
                current.left.right = current;
                current = current.left;
            } else if (x == current.x && y > current.y) {
                current.up = nodes[i];
                current.up.down = current;
                current = current.up;
            } else if (x == current.x && y < current.y) {
                current.down = nodes[i];
                current.down.up = current;
                current = current.down;
            }
        }
    }

    public static void main(String[] args) {
        new Figure().run();
    }
}

class Node {
    int x, y;
    Node up, down, left, right;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node next(Node prev) {
        if (this.right != null && !this.right.equals(prev)) {
            return this.right;
        } else if (this.up != null && !this.up.equals(prev)) {
            return this.up;
        } else if (this.left != null && !this.left.equals(prev)) {
            return this.left;
        } else {
            return this.down != null && !this.down.equals(prev) ? this.down : null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (x != node.x) return false;
        return y == node.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
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