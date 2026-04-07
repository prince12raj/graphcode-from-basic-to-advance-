import java.util.*;
public class C_Number_of_Minimums_on_a_Segment {
    static class Node {
        int num, count;
        Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    static class SegmentTree {
        int n;
        Node[] seg;
        SegmentTree(int[] arr) {
            n = arr.length;
            seg = new Node[4 * n];
            build(0, 0, n - 1, arr); 
        }
        Node Combine(Node a, Node b) {
            if (a.num < b.num) return a;
            if (b.num < a.num) return b;
            return new Node(a.num, a.count + b.count);
        }

        void build(int x, int lx, int rx, int[] arr) {
            if (lx == rx) {
                seg[x] = new Node(arr[lx], 1);
                return;
            }
            int mid = (lx + rx) / 2;
            build(2 * x + 1, lx, mid, arr);
            build(2 * x + 2, mid + 1, rx, arr);
            seg[x] = Combine(seg[2 * x + 1], seg[2 * x + 2]);
        }

        void update(int i, int val) {
            update(i, val, 0, 0, n - 1); 
        }

        void update(int i, int val, int x, int lx, int rx) {
            if (lx == rx) {
                seg[x] = new Node(val, 1);
                return;
            }
            int mid = (lx + rx) / 2;
            if (i <= mid) {
                update(i, val, 2 * x + 1, lx, mid);
            } else {
                update(i, val, 2 * x + 2, mid + 1, rx);
            }
            seg[x] = Combine(seg[2 * x + 1], seg[2 * x + 2]);
        }

        Node query(int l, int r) {
            return query(l, r, 0, 0, n - 1); 
        }
        Node query(int l, int r, int x, int lx, int rx) {
            if (rx < l || lx > r) {
                return new Node(Integer.MAX_VALUE, 0);
            }

            if (l <= lx && rx <= r) {
                return seg[x];
            }
            int mid = (lx + rx) / 2;
            Node left = query(l, r, 2 * x + 1, lx, mid);
            Node right = query(l, r, 2 * x + 2, mid + 1, rx);
            return Combine(left, right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        SegmentTree st = new SegmentTree(arr);
        while (m-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int i = sc.nextInt();
                int val = sc.nextInt();
                st.update(i, val);
            } else {
                int l = sc.nextInt();
                int r = sc.nextInt();
                Node res = st.query(l, r - 1);
                System.out.println(res.num + " " + res.count);
            }
        }
    }
}