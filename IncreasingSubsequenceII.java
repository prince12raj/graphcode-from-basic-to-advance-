// import java.util.*;
// public class IncreasingSubsequenceII {
//     static final int Mod = 1000000007;
//     static int[] arr, seg;
//     static int query(int idx, int l, int r, int ql, int qr) {
//         if (r < ql || l > qr) return 0;
//         if (ql <= l && r <= qr) return seg[idx];
//         int mid = (l + r) / 2;
//         int left = query(2 * idx + 1, l, mid, ql, qr);
//         int right = query(2 * idx + 2, mid + 1, r, ql, qr);
//         return (left + right) % Mod;
//     }
//     static void update(int idx, int l, int r, int pos, int val) {
//         if (l == r) {
//             seg[idx] = (seg[idx] + val) % Mod; 
//             return;
//         }
//         int mid = (l + r) / 2;
//         if (pos <= mid)
//             update(2 * idx + 1, l, mid, pos, val);
//         else
//             update(2 * idx + 2, mid + 1, r, pos, val);

//         seg[idx] = (seg[2 * idx + 1] + seg[2 * idx + 2]) % Mod;
//     }

//     static int binarySearch(int x, ArrayList<Integer> list) {
//         int l = 0, r = list.size() - 1;
//         while (l <= r) {
//             int mid = (l + r) / 2;
//             if (list.get(mid) == x) return mid;
//             else if (list.get(mid) < x) l = mid + 1;
//             else r = mid - 1;
//         }
//         return -1;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         arr = new int[n];
//         int[] col = new int[n];

//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//             col[i] = arr[i];
//         }
//         // coordinate compression
//         Arrays.sort(col);
//         ArrayList<Integer> unique = new ArrayList<>();
//         unique.add(col[0]);

//         for (int i = 1; i < n; i++) {
//             if (col[i] != col[i - 1]) {
//                 unique.add(col[i]);
//             }
//         }

//         int mx = unique.size();
//         seg = new int[4 * mx];
//         for (int i = 0; i < n; i++) {
//             int id = binarySearch(arr[i], unique);
//             int cnt = (id > 0) ? query(0, 0, mx - 1, 0, id - 1) : 0;
//             cnt = (cnt + 1) % Mod; 
//             update(0, 0, mx - 1, id, cnt);
//         }
//         int ans = query(0, 0, mx - 1, 0, mx - 1);
//         System.out.println(ans);
//     }
// }
import java.io.*;
import java.util.*;

public class IncreasingSubsequenceII {
    static final int Mod = 1000000007;
    static int[] arr, seg;

    static int query(int idx, int l, int r, int ql, int qr) {
        if (r < ql || l > qr) return 0;
        if (ql <= l && r <= qr) return seg[idx];
        int mid = (l + r) / 2;
        int left = query(2 * idx + 1, l, mid, ql, qr);
        int right = query(2 * idx + 2, mid + 1, r, ql, qr);
        return (left + right) % Mod;
    }

    static void update(int idx, int l, int r, int pos, int val) {
        if (l == r) {
            seg[idx] = (seg[idx] + val) % Mod;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid)
            update(2 * idx + 1, l, mid, pos, val);
        else
            update(2 * idx + 2, mid + 1, r, pos, val);

        seg[idx] = (seg[2 * idx + 1] + seg[2 * idx + 2]) % Mod;
    }
    static int binarySearch(int x, ArrayList<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid) == x) return mid;
            else if (list.get(mid) < x) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int[] col = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            col[i] = arr[i];
        }

        // coordinate compression
        Arrays.sort(col);
        ArrayList<Integer> unique = new ArrayList<>();
        unique.add(col[0]);

        for (int i = 1; i < n; i++) {
            if (col[i] != col[i - 1]) {
                unique.add(col[i]);
            }
        }

        int mx = unique.size();
        seg = new int[4 * mx];
        for (int i = 0; i < n; i++) {
            int id = binarySearch(arr[i], unique);
            int cnt = (id > 0) ? query(0, 0, mx - 1, 0, id - 1) : 0;
            cnt = (cnt + 1) % Mod;
            update(0, 0, mx - 1, id, cnt);
        }

        int ans = query(0, 0, mx - 1, 0, mx - 1);
        System.out.println(ans);
    }
}