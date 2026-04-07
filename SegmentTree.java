import java.util.*;
public class SegmentTree {
    static int arr[], seg[];
    static int n ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        seg = new int[4*n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        segbuild(0, 0, n-1);
        for(int x : seg){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(query(0, 0, n-1, 3, n-1));
    }
    static void segbuild(int idx ,int l ,int r){
        if(l==r){
            seg[idx] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;
        segbuild(2*idx+1, l, mid);
        segbuild(2*idx+2, mid+1, r);
        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }
    static int query(int idx , int l , int r, int ql , int qr){
        // completely outside
        if(r < ql || l > qr){
            return 0;
        }
        // completely inside
        if(ql <= l && r <= qr){
            return seg[idx];
        }
        // partially inside
        int mid = l + (r-l)/2;
        int left = query(2*idx+1, l, mid, ql, qr);
        int right = query(2*idx+2, mid+1, r, ql, qr);
        return left + right;
    }
    void update(int idx , int l , int r, int i , int nv){
        if(l==r){
            seg[idx] =nv;
            return;
        }
        int mid = l + (r-l)/2;
        if(i <= mid){
            update(2*idx+1, l , mid, i, nv);
        }
        else{
            update(2*idx+2, mid+1, r, i, nv);
        }
        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }
}
