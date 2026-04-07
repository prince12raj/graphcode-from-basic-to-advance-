import java.util.*;
class CountingRoom {
    static void dfs(int i , int j , char[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '#'){
            return;
        }
        grid[i][j] = '#';
        dfs(i-1, j, grid); 
        dfs(i+1, j, grid);
        dfs(i, j-1, grid); 
        dfs(i, j+1, grid); 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String s = sc.nextLine();
            for(int j = 0 ; j < m ; j++){
                grid[i][j] = s.charAt(j);
            }
        }
        int room = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '.'){
                    room++;
                    dfs(i, j, grid);
                }
            }
        }
        System.out.println(room);
        sc.close();
    }
}