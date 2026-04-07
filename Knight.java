import java.util.*;
public class Knight {
    static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
    static int bfs(int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[8][8];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                if (x == ex && y == ey)
                    return level;
                for (int k = 0; k < 8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < 8 && ny < 8 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            level++;
        }
        return 0;
    }
    static int minMoves(String start, String end) {
        int sx = start.charAt(0) - 'a';
        int sy = start.charAt(1) - '1';
        int ex = end.charAt(0) - 'a';
        int ey = end.charAt(1) - '1';
        return bfs(sx, sy, ex, ey);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String start = sc.next();
            String end = sc.next();
            System.out.println(minMoves(start, end));
        }
        sc.close();
    }
}
