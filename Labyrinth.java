import java.util.*;
public class Labyrinth {
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        int sx = 0, sy = 0, ex = 0, ey = 0;
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == 'A') {
                    sx = i;
                    sy = j;
                }
                if (grid[i][j] == 'B') {
                    ex = i;
                    ey = j;
                }
            }
        }
        bfs(grid, n, m, sx, sy, ex, ey);
        sc.close();
    }
    static void bfs(char[][] grid, int n, int m, int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[n][m];
        char[][] parent = new char[n][m];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy));
        visited[sx][sy] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] move = {'L', 'R', 'U', 'D'};
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == ex && cur.y == ey) {
                printPath(parent, sx, sy, ex, ey);
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && grid[nx][ny] != '#') {
                        visited[nx][ny] = true;
                        parent[nx][ny] = move[d];
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
        System.out.println("NO");
    }
    static void printPath(char[][] parent, int sx, int sy, int ex, int ey) {

        StringBuilder path = new StringBuilder();
        int x = ex, y = ey;
        while (x != sx || y != sy) {
            char c = parent[x][y];
            path.append(c);
            if (c == 'L') y++;
            else if (c == 'R') y--;
            else if (c == 'U') x++;
            else if (c == 'D') x--;
        }
        path.reverse();
        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path.toString());
    }
}
