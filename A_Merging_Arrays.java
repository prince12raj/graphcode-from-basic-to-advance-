import java.util.*;
class A_Merging_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        int i = 0, j = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while (i < n && j < m) {
            if (a[i] > b[j]) {
                arr.add(b[j]);
                j++;
            } 
            else if (a[i] == b[j]) {
                arr.add(a[i]);
                arr.add(b[j]);
                i++;
                j++;
            } 
            else {
                arr.add(a[i]);
                i++;
            }
        }
        while (i < n) {
            arr.add(a[i]);
            i++;
        }
        while (j < m) {
            arr.add(b[j]);
            j++;
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}