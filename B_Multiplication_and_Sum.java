import java.io.*;
import java.util.*;

public class B_Multiplication_and_Sum {
    static final long MOD = 1000000007;

    static class SegmentTree {
        int n;
        long[] tree, lazy;

        SegmentTree(int size) {
            n = size;
            tree = new long[4 * n];
            lazy = new long[4 * n];
            Arrays.fill(lazy, 1);
        }

        void push(int node, int l, int r) {
            if (lazy[node] != 1) {
                tree[node] = (tree[node] * lazy[node]) % MOD;
                if (l != r) {
                    lazy[2 * node] = (lazy[2 * node] * lazy[node]) % MOD;
                    lazy[2 * node + 1] = (lazy[2 * node + 1] * lazy[node]) % MOD;
                }
                lazy[node] = 1;
            }
        }

        void update(int node, int l, int r, int ql, int qr, long val) {
            push(node, l, r);
            if (r < ql || l > qr) return;
            if (ql <= l && r <= qr) {
                lazy[node] = (lazy[node] * val) % MOD;
                push(node, l, r);
                return;
            }
            int mid = (l + r) / 2;
            update(2 * node, l, mid, ql, qr, val);
            update(2 * node + 1, mid + 1, r, ql, qr, val);
            tree[node] = (tree[2 * node] + tree[2 * node + 1]) % MOD;
        }

        long query(int node, int l, int r, int ql, int qr) {
            push(node, l, r);
            if (r < ql || l > qr) return 0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            return (query(2 * node, l, mid, ql, qr) + query(2 * node + 1, mid + 1, r, ql, qr)) % MOD;
        }

        void multiply(int l, int r, long val) {
            update(1, 0, n - 1, l, r - 1, val);
        }

        long sum(int l, int r) {
            return query(1, 0, n - 1, l, r - 1);
        }

        void build(int node, int l, int r) {
            if (l == r) {
                tree[node] = 1;
                return;
            }
            int mid = (l + r) / 2;
            build(2 * node, l, mid);
            build(2 * node + 1, mid + 1, r);
            tree[node] = (tree[2 * node] + tree[2 * node + 1]) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        SegmentTree seg = new SegmentTree(n);
        seg.build(1, 0, n - 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (type == 1) {
                long v = Long.parseLong(st.nextToken());
                seg.multiply(l, r, v);
            } else {
                out.println(seg.sum(l, r));
            }
        }
        out.flush();
    }
}