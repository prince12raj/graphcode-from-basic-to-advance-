import java.util.*;
class Squrarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int x = 0; x < n; x++) {
            arr[x] = sc.nextInt();
        }
        int[] res = new int[n];
        int i = 0;  
        int j = n - 1;
        int k = n - 1;
        while (i <= j) {
            if (arr[i] * arr[i] < arr[j] * arr[j]) {
                res[k] = arr[j] * arr[j];
                j--;
            } else {
                res[k] = arr[i] * arr[i];
                i++;
            }
            k--;
        }
        for (int a : res) {
            System.out.print(a + " ");
        }
    }
}