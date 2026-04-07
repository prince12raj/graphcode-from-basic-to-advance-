import java.io.*;
import java.util.*;
public class C_Sereja_and_Brackets {
    static class Node {
        int open, close, full;

        Node(int o, int c, int f) {
            open = o;
            close = c;
            full = f;
        }
    }
    static String s;
    static Node[] seg;
    static Node merge(Node left, Node right) {
        int match = Math.min(left.open, right.close);
        int full = left.full + right.full + match;
        int open = left.open + right.open - match;
        int close = left.close + right.close - match;

        return new Node(open, close, full);
    }

    static void build(int idx, int l, int r) {
        if (l == r) {
            if (s.charAt(l) == '(')
                seg[idx] = new Node(1, 0, 0);
            else
                seg[idx] = new Node(0, 1, 0);
            return;
        }

        int mid = l + (r - l) / 2;

        build(2 * idx, l, mid);
        build(2 * idx + 1, mid + 1, r);

        seg[idx] = merge(seg[2 * idx], seg[2 * idx + 1]);
    }

    static Node query(int idx, int l, int r, int ql, int qr) {
        if (qr < l || r < ql)
            return new Node(0, 0, 0);
        if (ql <= l && r <= qr)
            return seg[idx];
        int mid = l + (r - l) / 2;
        Node left = query(2 * idx, l, mid, ql, qr);
        Node right = query(2 * idx + 1, mid + 1, r, ql, qr);
        return merge(left, right);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        int n = s.length();
        seg = new Node[4 * n];
        build(1, 0, n - 1);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            Node res = query(1, 0, n - 1, l, r);
            sb.append(2 * res.full).append('\n');
        }
        System.out.print(sb);
    }
}