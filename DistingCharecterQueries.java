import java.util.*;
public class DistingCharecterQueries {
    static class Node {
        int[] freq;
        Node() {
            freq = new int[26];
        }
    }
    static Node[] seg;
    static char[] s;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine().toCharArray();
        n = s.length;
        seg = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            seg[i] = new Node();
        }
        build(0, 0, n - 1);
        int q = sc.nextInt();
        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int pos = sc.nextInt() - 1;
                char c = sc.next().charAt(0);
                update(0, 0, n - 1, pos, c);
            } else {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;
                Node res = query(0, 0, n - 1, l, r);
                int count = 0;
                for (int i = 0; i < 26; i++) {
                    if (res.freq[i] > 0) count++;
                }
                System.out.println(count);
            }
        }
    }

    static Node combine(Node left, Node right) {
        Node res = new Node();
        for (int i = 0; i < 26; i++) {
            res.freq[i] = left.freq[i] + right.freq[i];
        }
        return res;
    }
    static void build(int idx, int l, int r) {
        if (l == r) {
            seg[idx].freq[s[l] - 'a'] = 1;
            return;
        }
        int mid = (l + r) / 2;
        build(2 * idx + 1, l, mid);
        build(2 * idx + 2, mid + 1, r);

        seg[idx] = combine(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
    static Node query(int idx, int l, int r, int ql, int qr) {
        if (r < ql || l > qr) {
            return new Node();
        }
        if (ql <= l && r <= qr) {
            return seg[idx];
        }
        int mid = (l + r) / 2;
        Node left = query(2 * idx + 1, l, mid, ql, qr);
        Node right = query(2 * idx + 2, mid + 1, r, ql, qr);
        return combine(left, right);
    }
    static void update(int idx, int l, int r, int pos, char c) {
        if (l == r) {
            Arrays.fill(seg[idx].freq, 0);
            seg[idx].freq[c - 'a'] = 1;
            s[pos] = c;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) {
            update(2 * idx + 1, l, mid, pos, c);
        } else {
            update(2 * idx + 2, mid + 1, r, pos, c);
        }
        seg[idx] = combine(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
}