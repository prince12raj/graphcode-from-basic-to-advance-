import java.util.*;

public class B_Closest_to_the_Left {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        while (k-- > 0) {
            int x = sc.nextInt();
            System.out.println(upperBound(arr, x));
        }
    }
    static int upperBound(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= x) {
                ans = mid; 
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans + 1;
    }
}