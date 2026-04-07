import java.util.*;
import java.io.*;
public class Monster {
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int n, m;
    static char[][] grid;
    static int[][] monsterTime, playerTime;
    static int[][] parent;
    static final int INF = (int) 1e9;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static char[] dirChar = {'D', 'U', 'R', 'L'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        monsterTime = new int[n][m];
        playerTime = new int[n][m];
        parent = new int[n][m];
        Queue<Node> que = new ArrayDeque<>();
        Node start = null;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
                monsterTime[i][j] = INF;
                playerTime[i][j] = INF;
                parent[i][j] = -1;
                if (grid[i][j] == 'M') {
                    que.add(new Node(i, j));
                    monsterTime[i][j] = 0;
                }
                if (grid[i][j] == 'A') {
                    start = new Node(i, j);
                }
            }
        }
        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (grid[nr][nc] == '#') continue;

                if (monsterTime[nr][nc] == INF) {
                    monsterTime[nr][nc] = monsterTime[cur.r][cur.c] + 1;
                    que.add(new Node(nr, nc));
                }
            }
        }
        if (start.r == 0 || start.c == 0 || start.r == n - 1 || start.c == m - 1) {
            System.out.println("YES");
            System.out.println(0);
            System.out.println();
            return;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        playerTime[start.r][start.c] = 0;

        Node escape = null;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (grid[nr][nc] == '#') continue;
                if (playerTime[nr][nc] != INF) continue;
                int nextTime = playerTime[cur.r][cur.c] + 1;
                if (nextTime < monsterTime[nr][nc]) {
                    playerTime[nr][nc] = nextTime;
                    parent[nr][nc] = d;
                    q.add(new Node(nr, nc));
                    if (nr == 0 || nc == 0 || nr == n - 1 || nc == m - 1) {
                        escape = new Node(nr, nc);
                        q.clear();
                        break;
                    }
                }
            }
        }

        if (escape == null) {
            System.out.println("NO");
            return;
        }
        StringBuilder path = new StringBuilder();
        int r = escape.r, c = escape.c;

        while (!(r == start.r && c == start.c)) {
            int d = parent[r][c];
            path.append(dirChar[d]);
            r -= dr[d];
            c -= dc[d];
        }
        path.reverse();
        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path.toString());
    }
}
