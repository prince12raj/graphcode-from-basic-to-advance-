import java.util.*;
public class B_Number_of_Smaller {
    static int lowerBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (a[mid] < x) l = mid + 1;
            else r = mid;
        }
        return l;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();

        for (int j = 0; j < m; j++) {
            System.out.print(lowerBound(a, b[j]) + " ");
        }
        sc.close();
    }
}