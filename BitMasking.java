import java.util.*;
class BitMasking{
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n = sc.nextInt();
        int worker[] = new int[n];
        for(int i=0;i<n;i++){
            int no_ofdays = sc.nextInt();
            int mask =0;
            for(int j=0;j<no_ofdays;j++){
                int day = sc.nextInt();
                mask |= (1<<day);
            }
            worker[i] = mask;
        }
        for(int i=0;i<n;i++){
            System.out.print("worker works on " + worker[i] + " days ");
            printBinary(worker[i]);
            System.out.println();
        }
        System.out.println("finding max days of two workers work together");
        int mx = -1 , p1 =-1, p2 = -1;
        for(int i= 0 ; i<n-1; i++){
            for(int j =i+1; j<n; j++){
                int common = worker[i] & worker[j];
                int setcount = Countsetbit(common);
                if(setcount>mx){
                    mx = setcount;
                    p1 = i;
                    p2 = j;
                }
                System.out.println("worker " + i + " and worker " + j + " works together on " + setcount + " days");
            }
        }
        System.out.println("worker " + p1 + " and worker " + p2 + " works together on " + mx + " days");
    }
    static int Countsetbit(int n){
        int count =0;
        while(n>0){
            count += (n&1);
            n>>=1;
        }
        return count;
    }
    static void printBinary(int n) {
        if (n == 0) {
            System.out.print(0);
            return;
        }
        if (n > 1) {
            printBinary(n / 2);
        }
        System.out.print(n % 2);
    }
}