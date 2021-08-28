package task59;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        Direction direction = Direction.RIGHT;
        int currentNum = 1;
        int i = 0;
        int j = 0;
        while (currentNum != n * n) {
            matrix[i][j] = currentNum;
            switch (direction) {
                case RIGHT:
                    if (j == n - 1 || matrix[i][j + 1] != 0) {
                        direction = Direction.DOWN;
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case LEFT:
                    if (j == 0 || matrix[i][j - 1] != 0) {
                        direction = Direction.UP;
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case UP:
                    if (i == 0 || matrix[i - 1][j] != 0) {
                        direction = Direction.RIGHT;
                        j++;
                    } else {
                        i--;
                    }
                    break;
                case DOWN:
                    if (i == n - 1 || matrix[i + 1][j] != 0) {
                        direction = Direction.LEFT;
                        j--;
                    } else {
                        i++;
                    }
                    break;
            }
            currentNum++;
        }
        matrix[i][j] = currentNum;
        return matrix;
    }

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN;
    }
}
