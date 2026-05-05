import java.util.*;
public class D_Fast_search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int q = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int left = lowerBound(a, l);
            int right = upperBound(a, r);
            sb.append(right - left).append(" ");
        }
        System.out.println(sb.toString());
    }
    static int lowerBound(int[] a, int target) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (a[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    static int upperBound(int[] a, int target) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (a[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}