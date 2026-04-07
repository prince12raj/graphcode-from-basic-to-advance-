import java.util.*;
public class Gridques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String[][] grid = new String[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.next();
            }
        }
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
                if (grid[i][j].equals("E")) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        printPath(start[0], start[1], end[0], end[1], grid);
        sc.close();
    }

    static void printPath(int i, int j, int k, int l, String[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        StringBuilder path = new StringBuilder();
        while (!(i == k && j == l)) {
            if (visited[i][j]) {
                System.out.println("No valid path (loop detected)");
                return;
            }
            visited[i][j] = true;
            String move = grid[i][j];

            if (move.equals("L")) {
                j--;
                path.append("L");
            } else if (move.equals("R")) {
                j++;
                path.append("R");
            } else if (move.equals("U")) {
                i--;
                path.append("U");
            } else if (move.equals("D")) {
                i++;
                path.append("D");
            } else if (move.equals("S")) {
            } else {
                System.out.println("Invalid move at " + i + "," + j);
                return;
            }
            if (i < 0 || j < 0 || i >= m || j >= n) {
                System.out.println("Out of grid");
                return;
            }
        }

        System.out.println("Path: " + path.toString());
    }
}
