import java.util.*;
public class TheLakes {
    static int bfs(int si, int sj, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{si, sj});
        sum += grid[si][sj];
        grid[si][sj] = 0; 
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] != 0) {
                    sum += grid[nx][ny];
                    grid[nx][ny] = 0; 
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] != 0) {
                        cnt = Math.max(cnt, bfs(i, j, grid));
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}
