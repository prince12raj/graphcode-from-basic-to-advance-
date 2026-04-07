import java.io.*;
import java.util.*;

public class A_Addition_and_Minimum {
    static class SegmentTree {
        int n;
        long[] tree, lazy;

        SegmentTree(int size) {
            n = size;
            tree = new long[4 * n];
            lazy = new long[4 * n];
        }

        void push(int node, int l, int r) {
            if (lazy[node] != 0) {
                tree[node] += lazy[node];
                if (l != r) { 
                    lazy[2 * node] += lazy[node];
                    lazy[2 * node + 1] += lazy[node];
                }
                lazy[node] = 0;
            }
        }

        void update(int node, int l, int r, int ql, int qr, long val) {
            push(node, l, r);
            if (r < ql || l > qr) return;
            if (ql <= l && r <= qr) {
                lazy[node] += val;
                push(node, l, r);
                return;
            }
            int mid = (l + r) / 2;
            update(2 * node, l, mid, ql, qr, val);
            update(2 * node + 1, mid + 1, r, ql, qr, val);
            tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
        }

        long query(int node, int l, int r, int ql, int qr) {
            push(node, l, r);
            if (r < ql || l > qr) return Long.MAX_VALUE;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            return Math.min(query(2 * node, l, mid, ql, qr),
                            query(2 * node + 1, mid + 1, r, ql, qr));
        }

        void add(int l, int r, long val) {
            update(1, 0, n - 1, l, r - 1, val);
        }

        long min(int l, int r) {
            return query(1, 0, n - 1, l, r - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        SegmentTree seg = new SegmentTree(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (type == 1) { 
                long v = Long.parseLong(st.nextToken());
                seg.add(l, r, v);
            } else { 
                out.println(seg.min(l, r));
            }
        }
        out.flush();
    }
}